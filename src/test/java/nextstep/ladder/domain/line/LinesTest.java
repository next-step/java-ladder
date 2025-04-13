package nextstep.ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LinesTest {

    @DisplayName("Lines 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Lines(4, new Height(3), new LineFactory(new PointFactory())));
    }
}
