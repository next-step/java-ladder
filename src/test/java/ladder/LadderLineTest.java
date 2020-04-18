package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    private LadderLine ladderLine;

    @BeforeEach
    void setUp() {
        /**
         *  0   1   2   3   4
         *  |---|   |---|   |
         */
        ladderLine = LadderLine.of(5, () -> TRUE);
    }

    @DisplayName("특정 좌표 move")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2", "4:4"}, delimiter = ':')
    void move(int startPoint, int endPoint) {
        assertThat(ladderLine.move(startPoint)).isEqualTo(endPoint);
    }

    @DisplayName("라인 전체 좌표 move")
    @Test
    void move() {
        assertThat(ladderLine.move()).containsExactly(1, 0, 3, 2, 4);
    }

    @DisplayName("Direction 없을때 move")
    @Test
    void moveByNonDirection() {
        ladderLine = LadderLine.of(5, () -> FALSE);
        assertThat(ladderLine.move()).containsExactly(0, 1, 2, 3, 4);
    }
}
