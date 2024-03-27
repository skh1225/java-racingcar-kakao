package carrace;

import static org.assertj.core.api.Assertions.*;

import carrace.domain.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        assertThat(car.moveForward()).isEqualTo(2);
    }

    @Test
    void name() {
        Car car = new Car("pobi");
        String carName = car.getName();
        assertThat(carName).isEqualTo("pobi");
    }

    @Test
    void carNameLengthOver5() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Car("pobiii"));
    }
}