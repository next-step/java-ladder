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
        List<HorizontalLine> horizontalLines = Arrays.asList(new HorizontalLine(0), new HorizontalLine(1));
        this.horizontalLines = new HorizontalLines(horizontalLines);
    }

    @Test
    @DisplayName("findByIndex 테스트")
    void findByIndexTest() {
        assertTrue(horizontalLines.findByIndex(0).isPresent());
        assertTrue(horizontalLines.findByIndex(1).isPresent());
        assertFalse(horizontalLines.findByIndex(2).isPresent());
        assertFalse(horizontalLines.findByIndex(3).isPresent());
        assertFalse(horizontalLines.findByIndex(4).isPresent());
    }

    @Test
    @DisplayName("size 테스트")
    void sizeTest() {
        assertEquals(2, horizontalLines.size());
    }
}
