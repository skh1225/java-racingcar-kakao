import static org.assertj.core.api.Assertions.*;

import java.util.List;

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
		CarRace carRace = new CarRace(new CarMoveRule(), cars,5 );
		List<Car> result = carRace.getCars();

		for (Car car : cars) {
			assertThat(result).contains(car);
		}
	}
	@CsvSource({"true, 2", "false, 1"})
	@ParameterizedTest
	void runRound(boolean returnValue, int position) {
		CarRace carRace = new CarRace(new TestCarMoveRule(returnValue), cars, 5);

		carRace.runRound();
		for (Car car : carRace.getCars()) {
			assertThat(car.getPosition()).isEqualTo(position);
		}
	}

	@Test
	void isEnd_stage5call5() {
		CarRace carRace = new CarRace(new CarMoveRule(), cars, 5);
		for (int i = 0; i < 5; i++) {
			carRace.runRound();
		}
		assertThat(carRace.isEnd()).isTrue();
	}

	@Test
	void isEnd_stage5call3() {
		CarRace carRace = new CarRace(new CarMoveRule(), cars, 5);
		for (int i = 0; i < 3; i++) {
			carRace.runRound();
		}
		assertThat(carRace.isEnd()).isFalse();
	}
}
