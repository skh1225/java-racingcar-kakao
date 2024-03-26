import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRace {
	private final List<Car> cars;
	private final CarMoveRule carMoveRule;

	public CarRace(CarMoveRule carMoveRule, List<Car> cars) {
		this.carMoveRule = carMoveRule;
		this.cars = cars;
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public void runRound() {
		for (Car car : cars) {
			boolean move = carMoveRule.move();
			if (move) {
				car.moveForward();
			}
		}
	}

	public List<Car> getWinningCars() {
		int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
		return cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
	}
}
