import static org.assertj.core.api.Assertions.*;

import java.util.List;

import carrace.domain.Car;
import carrace.domain.CarRace;
import carrace.domain.CarMoveRule;
import carrace.domain.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarRaceTest {
	private List<Car> cars;
	@BeforeEach
	void setUp() {
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Car car3 = new Car("car3");
		cars = List.of(car1, car2, car3);
	}

	@Test
	void getCars() {
		CarRace carRace = new CarRace(new CarMoveRule(new RandomNumberGenerator()), cars);
		List<Car> result = carRace.getCars();

		for (Car car : cars) {
			assertThat(result).contains(car);
		}
	}
	@CsvSource({"9, 2", "1, 1"})
	@ParameterizedTest
	void runRound(int generatedNumber, int position) {
		CarRace carRace = new CarRace(new CarMoveRule(() -> generatedNumber), cars);

		carRace.runRound();
		for (Car car : carRace.getCars()) {
			assertThat(car.getPosition()).isEqualTo(position);
		}
	}

	@Test
	void getWinningCars_singleWinner() {
		cars.get(0).moveForward();
		cars.get(0).moveForward();
		cars.get(0).moveForward();
		cars.get(1).moveForward();
		cars.get(1).moveForward();

		CarRace carRace = new CarRace(new CarMoveRule(new RandomNumberGenerator()), cars);

		List<Car> winningCars = carRace.getWinningCars();

		assertThat(winningCars).contains(cars.get(0));
	}

	@Test
	void getWinningCars_multipleWinner() {
		cars.get(0).moveForward();
		cars.get(0).moveForward();
		cars.get(1).moveForward();
		cars.get(1).moveForward();

		CarRace carRace = new CarRace(new CarMoveRule(new RandomNumberGenerator()), cars);

		List<Car> winningCars = carRace.getWinningCars();

		assertThat(winningCars).contains(cars.get(0));
		assertThat(winningCars).contains(cars.get(1));
	}
}
