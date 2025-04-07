package nextstep.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PointTest {

    @Test
    @DisplayName("false는 연결되지 않은 값이다.")
    public void getFalsePoint() {
        assertFalse(new Point(() -> false).isConnected());
    }

    @Test
    @DisplayName("true는 연결된 값이다.")
    public void getTruePoint() {
        assertTrue(new Point(() -> true).isConnected());
    }
}