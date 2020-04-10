package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static ladder.domain.type.DirectionType.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    private LadderLine ladderLine;

    @BeforeEach
    void setUp() {
        ladderLine = new LadderLine(Arrays.asList(new Point(0, RIGHT),
                new Point(1, LEFT),
                new Point(2, DOWN),
                new Point(3, DOWN)));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:2", "3:3"}, delimiter = ':')
    void move(int value, int expected) {
        int move = ladderLine.move(value);

        assertThat(move).isEqualTo(expected);
    }

    @Test
    void getSize() {
        int size = ladderLine.getSize();

        assertThat(size).isEqualTo(4);
    }

    @Test
    void of() {
        LadderLine ladderLine = LadderLine.of(3);

        assertThat(ladderLine.getPoints()).hasSize(3);
    }
}
