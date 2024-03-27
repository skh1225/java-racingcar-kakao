package carrace.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarRace {

	private final CarMoveRule carMoveRule;
	private final List<Car> cars;
	private final int totalRound;
	private int currentRound;

	public CarRace(CarMoveRule carMoveRule, List<Car> cars, int totalRound) {
		validateDuplicateCarNames(cars);
		this.carMoveRule = carMoveRule;
		this.cars = cars;
		this.totalRound = totalRound;
	}

	public void runRound() {
		for (Car car : cars) {
			moveIfMovable(car);
		}
		currentRound++;
	}

	private void moveIfMovable(Car car) {
		if (carMoveRule.isMovable()) {
			car.moveForward();
		}
	}

	public List<Car> getWinningCars() {
		int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
		return cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
	}

	public List<Car> getCars() {
		return this.cars;
	}

	private void validateDuplicateCarNames(List<Car> cars) {
		if (cars.size() != cars.stream().map(Car::getName).distinct().count()) {
			throw new IllegalArgumentException("중복된 자동차의 이름이 존재합니다.");
		}
	}

	private void validateRound() {
		if (cars.size() != cars.stream().map(Car::getName).distinct().count()) {
			throw new IllegalArgumentException("중복된 자동차의 이름이 존재합니다.");
		}
	}

	public boolean isEnd() {
		return totalRound == currentRound;
	}
}
