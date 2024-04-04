package com.boardcamp.api.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.boardcamp.api.dtos.RentalDTO;
import com.boardcamp.api.exceptions.CustomerNotFoundException;
import com.boardcamp.api.exceptions.GameNotFoundException;
import com.boardcamp.api.exceptions.RentalNotFoundException;
import com.boardcamp.api.exceptions.RentalUnprocessableEntityException;
import com.boardcamp.api.models.CustomerModel;
import com.boardcamp.api.models.GameModel;
import com.boardcamp.api.models.RentalModel;
import com.boardcamp.api.repositories.CustomerRepository;
import com.boardcamp.api.repositories.GameRepository;
import com.boardcamp.api.repositories.RentalRepository;

@Service
public class RentalService {

	final RentalRepository rentalRepository;
	final GameRepository gameRepository;
	final CustomerRepository customerRepository;

	RentalService(RentalRepository rentalRepository, GameRepository gameRepository,
			CustomerRepository customerRepository) {
		this.rentalRepository = rentalRepository;
		this.gameRepository = gameRepository;
		this.customerRepository = customerRepository;
	}

	public List<RentalModel> findAll() {
		return rentalRepository.findAll();
	}

	public RentalModel save(RentalDTO dto) {
		CustomerModel customer = customerRepository.findById(dto.getCustomerId()).orElseThrow(
				() -> new CustomerNotFoundException("User not found!"));

		GameModel game = gameRepository.findById(Objects.requireNonNull(dto.getGameId())).orElseThrow(
				() -> new GameNotFoundException("Game not found!"));

		if (game.getStockTotal() <= 0) {
			throw new RentalUnprocessableEntityException("The selected game is not available!");
		}

		game.setStockTotal(game.getStockTotal() - 1);

		RentalModel rental = new RentalModel(dto, customer, game);
		return rentalRepository.save(rental);
	}

	public RentalModel update(Long id) {
		RentalModel rental = rentalRepository.findById(id).orElseThrow(
				() -> new RentalNotFoundException("Rental not found!"));

		if (rental.getReturnDate() != null) {
			throw new RentalUnprocessableEntityException("The rental has already been paid!");
		}

		GameModel game = gameRepository.findById(Objects.requireNonNull(rental.getGame().getId())).orElseThrow(
				() -> new GameNotFoundException("Game not found!"));

		game.setStockTotal(game.getStockTotal() + 1);

		LocalDate returnDate = LocalDate.now();
		rental.setReturnDate(returnDate);

		long numberDaysRented = ChronoUnit.DAYS.between(rental.getRentDate(), returnDate);

		if (numberDaysRented > rental.getDaysRented()) {
			Long delayFee = game.getPricePerDay() * (numberDaysRented - rental.getDaysRented());
			rental.setOriginalPrice(rental.getOriginalPrice() + delayFee);

		}

		return rental;
	}

}