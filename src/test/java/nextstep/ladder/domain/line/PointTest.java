package nextstep.ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PointTest {

    @DisplayName("Point 인스턴스 객체 생성")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Point(true));
        assertDoesNotThrow(() -> new Point(false));
    }
}
