package carrace;

import carrace.domain.Car;
import carrace.domain.CarRace;
import carrace.domain.CarMoveRule;
import carrace.domain.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class CarRaceController {

	private final CarRaceView view;

	public CarRaceController(CarRaceView view) {
		this.view = view;
	}

	public void play() {
		CarRace carRace = initCarRace();
		int round = initRound();
		proceedRounds(carRace, round);
		endRace(carRace);
	}

	private CarRace initCarRace() {
		return new CarRace(new CarMoveRule(new RandomNumberGenerator()), createCars(view.getCarNames()));
	}

	private List<Car> createCars(List<String> carNames) {
		return carNames.stream().map(Car::new).collect(Collectors.toList());
	}

	private int initRound() {
		return view.getCarRaceRound();
	}

	private void proceedRounds(CarRace carRace, int round) {
		view.displayResultStartMessage();
		view.displayRoundResult(carRace.getCars());
		for (int r = 0; r < round; r++) {
			carRace.runRound();
			view.displayRoundResult(carRace.getCars());
		}
	}

	private void endRace(CarRace carRace) {
		view.displayWinnerNames(carRace.getWinningCars()
			.stream()
			.map(Car::getName)
			.collect(Collectors.toList()));
	}
}