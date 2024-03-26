package carrace.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarRace {

	private final CarMoveRule carMoveRule;
	private final List<Car> cars;

	public CarRace(CarMoveRule carMoveRule, List<Car> cars) {
		this.carMoveRule = carMoveRule;
		this.cars = cars;
	}

	public void runRound() {
		for (Car car : cars) {
			moveIfMovable(car);
		}
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
}
