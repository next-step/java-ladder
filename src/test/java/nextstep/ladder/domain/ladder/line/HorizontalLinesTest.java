package nextstep.ladder.domain.ladder.line;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @DisplayName("exist 테스트")
    @ValueSource(ints = {0,1})
    void existTest(int index) {
        assertTrue(horizontalLines.exist(index));
    }

    @ParameterizedTest
    @DisplayName("사이즈 보다 큰 인덱스를 사용하는 경우 예외가 발생한다")
    @ValueSource(ints = {2,5,10})
    void exceedSizeIndexTest(int index) {
        assertThrows(IllegalArgumentException.class, () -> horizontalLines.get(index));
        assertThrows(IllegalArgumentException.class, () -> horizontalLines.exist(index));
    }

    @ParameterizedTest
    @DisplayName("음수 인덱스를 사용하는 경우 예외가 발생한다")
    @ValueSource(ints = {-1,-2,-10})
    void negativeIndexTest(int index) {
        assertThrows(IllegalArgumentException.class, () -> horizontalLines.get(index));
        assertThrows(IllegalArgumentException.class, () -> horizontalLines.exist(index));
    }

    @Test
    @DisplayName("size 테스트")
    void sizeTest() {
        assertEquals(2, horizontalLines.size());
    }
}
