import java.util.List;

public class CarRace {
	private final List<Car> cars;
	private final CarMoveRule carMoveRule;
	private final int maxStage;
	private int currentStage = 0;

	public CarRace(CarMoveRule carMoveRule, List<Car> cars, int maxStage) {
		this.carMoveRule = carMoveRule;
		this.cars = cars;
		this.maxStage = maxStage;
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public void runRound() {
		// stage number ++
		currentStage++;

		// cars move
		for (Car car : cars) {
			boolean move = carMoveRule.move();
			if (move) {
				car.moveForward();
			}
		}
	}

	public boolean isEnd() {
		return maxStage == currentStage;
	}
}
