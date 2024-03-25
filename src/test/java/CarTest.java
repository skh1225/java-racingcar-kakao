import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @CsvSource({"pobiii, false", "pobii, true", "p, true"})
    @ParameterizedTest
    void validateName(String name, boolean isValid) {
        Throwable thrown = catchThrowable(() -> new Car(name));
        if (!isValid) {
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
            return;
        }
        assertThat(thrown).isNull();
    }

}
