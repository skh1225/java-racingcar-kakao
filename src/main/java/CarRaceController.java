import java.util.List;
import java.util.stream.Collectors;

public class CarRaceController {

	private final CarRaceView view;

	public CarRaceController(CarRaceView view) {
		this.view = view;
	}

	public void play() {
		CarRace carRace = new CarRace(new CarMoveRule(), createCars(view.getCarNames()));
		int round = view.getCarRaceRound();
		view.displayResultStartMessage();
		view.displayRoundResult(carRace.getCars());
		for (int r = 0; r < round; r++) {
			carRace.runRound();
			view.displayRoundResult(carRace.getCars());
		}
		view.displayWinnerNames(carRace.getWinningCars()
			.stream()
			.map(Car::getName)
			.collect(Collectors.toList()));
	}

	private List<Car> createCars(List<String> carNames) {
		return carNames.stream().map(Car::new).collect(Collectors.toList());
	}
}
