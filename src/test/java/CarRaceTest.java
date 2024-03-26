import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;

import carrace.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarRaceTest {

    private NumberGenerator randomNumberGenerator;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        cars = List.of(car1, car2, car3);
    }

    @Test
    void getCars() {
        CarRace carRace = new CarRace(new CarMoveRule(randomNumberGenerator), cars);

        List<Car> result = carRace.getCars();

        assertThat(result).containsAll(cars);
    }

    @CsvSource({"4, 2", "3, 1"})
    @ParameterizedTest
    void runRound(int generatedNumber, int position) {
        CarRace carRace = new CarRace(new CarMoveRule(() -> generatedNumber), cars);

        carRace.runRound();

        assertThat(carRace.getCars()).extracting(Car::getPosition).containsOnly(position);
    }

    @Test
    void getWinningCars_singleWinner() {
        Car winnerCar = cars.get(0);
        CarRace carRace = createCarRaceWithSingleWinner(winnerCar);

        List<Car> winningCars = carRace.getWinningCars();

        assertSoftly(softly -> {
            softly.assertThat(winningCars).contains(winnerCar);
            softly.assertThat(winningCars.size()).isEqualTo(1);
        });
    }

    private CarRace createCarRaceWithSingleWinner(Car winnerCar) {
        winnerCar.moveForward();
        winnerCar.moveForward();
        return new CarRace(new CarMoveRule(randomNumberGenerator), cars);
    }

    @Test
    void getWinningCars_multipleWinner() {
        Car winnerCar1 = cars.get(0);
        Car winnerCar2 = cars.get(1);
        CarRace carRace = createCarRaceWithTwoWinners(winnerCar1, winnerCar2);

        List<Car> winningCars = carRace.getWinningCars();

        assertSoftly(softly -> {
            softly.assertThat(winningCars).containsAll(List.of(winnerCar1, winnerCar2));
            softly.assertThat(winningCars.size()).isEqualTo(2);
        });
    }

    private CarRace createCarRaceWithTwoWinners(Car winnerCar1, Car winnerCar2) {
        winnerCar1.moveForward();
        winnerCar1.moveForward();
        winnerCar2.moveForward();
        winnerCar2.moveForward();
        return new CarRace(new CarMoveRule(randomNumberGenerator), cars);
    }
}
