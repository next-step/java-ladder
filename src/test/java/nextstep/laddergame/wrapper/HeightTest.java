package nextstep.laddergame.wrapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HeightTest {

    @Test
    void number_constraint_test() {
        String WRONG_PARAMETER = "wrong_parameter";
        String RIGHT_PARAMETER = "5";

        assertDoesNotThrow(() -> new Height(RIGHT_PARAMETER));
        assertThrows(IllegalArgumentException.class, () -> new Height(WRONG_PARAMETER));
    }
}