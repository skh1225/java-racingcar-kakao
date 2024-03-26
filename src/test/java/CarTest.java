import carrace.domain.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void initialPosition1() {
        Car car = new Car("pobi");
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ValueSource(ints = {1, 3, 5, 11})
    @ParameterizedTest
    void moveForward(int moveCount) {
        Car car = new Car("pobi");
        for (int i = 0; i < moveCount; i++) {
            car.moveForward();
        }
        assertThat(car.getPosition()).isEqualTo(1 + moveCount);
    }

    @Test
    void name() {
        Car car = new Car("pobi");
        String carName = car.getName();
        assertThat(carName).isEqualTo("pobi");
    }
}