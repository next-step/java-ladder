package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

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
        ladderLine = new LadderLine(Arrays.asList(
                new Point(0, Direction.of(FALSE, TRUE)),
                new Point(1, Direction.of(TRUE, FALSE)),
                new Point(2, Direction.of(FALSE, TRUE)),
                new Point(3, Direction.of(TRUE, FALSE)),
                new Point(4, Direction.of(FALSE, FALSE))
        ));
    }

    @Test
    void create() {
        LadderLine ladderLine = LadderLine.from(new LadderLineInfo(3, () -> true));
        assertThat(ladderLine).isEqualTo(new LadderLine(Arrays.asList(
                new Point(0, Direction.of(FALSE, TRUE)),
                new Point(1, Direction.of(TRUE, FALSE)),
                new Point(2, Direction.of(FALSE, FALSE)
                ))));
    }

    @DisplayName("특정 좌표 move")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2", "4:4"}, delimiter = ':')
    void move(int startPoint, int endPoint) {
        assertThat(ladderLine.move(new Position(startPoint))).isEqualTo(new Position(endPoint));
    }
}
