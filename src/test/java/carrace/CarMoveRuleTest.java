package carrace;

import carrace.domain.CarMoveRule;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMoveRuleTest {

    @CsvSource({"0, false", "3, false", "4, true", "9, true"})
    @ParameterizedTest
    void move(int value, boolean move) {
        CarMoveRule carMoveRule = new CarMoveRule(() -> value);
        boolean result = carMoveRule.isMovable();
        assertThat(result).isEqualTo(move);
    }
}
