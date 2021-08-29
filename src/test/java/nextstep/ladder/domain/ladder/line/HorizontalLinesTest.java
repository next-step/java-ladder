package nextstep.ladder.domain.ladder.line;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HorizontalLinesTest {

    private HorizontalLines horizontalLines;

    @BeforeEach
    void setUp() {
        List<HorizontalLine> horizontalLines = Arrays.asList(new HorizontalLine(true), new HorizontalLine(true));
        this.horizontalLines = new HorizontalLines(horizontalLines);
    }

    @Test
    @DisplayName("exist 테스트")
    void existTest() {
        assertTrue(horizontalLines.exist(0));
        assertTrue(horizontalLines.exist(1));
    }

    @Test
    @DisplayName("사이즈 보다 큰 인덱스를 사용하는 경우 예외가 발생한다")
    void exceedSizeIndexTest() {
        assertThrows(IllegalArgumentException.class, () -> horizontalLines.get(2));
        assertThrows(IllegalArgumentException.class, () -> horizontalLines.exist(2));
    }

    @Test
    @DisplayName("음수 인덱스를 사용하는 경우 예외가 발생한다")
    void negativeIndexTest() {
        assertThrows(IllegalArgumentException.class, () -> horizontalLines.get(-1));
        assertThrows(IllegalArgumentException.class, () -> horizontalLines.exist(-10));
    }

    @Test
    @DisplayName("size 테스트")
    void sizeTest() {
        assertEquals(2, horizontalLines.size());
    }
}
