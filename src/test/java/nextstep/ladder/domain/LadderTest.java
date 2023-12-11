package nextstep.ladder.domain;

import nextstep.ladder.exception.CannotMakeLadderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    @Test
    @DisplayName("사다리 높이가 1보다 작은 경우 Exception Throw")
    void ladder_Height_Exception_Test() {
        assertThrows(CannotMakeLadderException.class, () -> Ladder.generate(3, 0));
    }
}
