package carrace;

import static org.assertj.core.api.Assertions.*;

import carrace.domain.Car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @Test
    @DisplayName("자동차의 초기 위치는 1이다.")
    void initialPosition1() {
        Car car = new Car("pobi");
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ValueSource(ints = {1, 3, 5, 11})
    @ParameterizedTest
    @DisplayName("자동차에 전진 명령을 내리면 위치가 1늘어난다.")
    void moveForward(int moveCount) {
        Car car = new Car("pobi");
        assertThat(car.moveForward()).isEqualTo(2);
    }

    @Test
    @DisplayName("getName 메소드는 자동차의 이름을 반환한다.")
    void name() {
        Car car = new Car("pobi");
        String carName = car.getName();
        assertThat(carName).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차의 이름은 5를 초과해서는 안된다.")
    void carNameLengthOver5() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Car("pobiii"));
    }
}