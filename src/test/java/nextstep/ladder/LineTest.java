package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class LineTest {

    private final int participantsCount = 5;

    @Test
    void lineDrawTest() {
        Line line = new Line(participantsCount, drawLineRandomMock());

        assertThat(line.isNotDrawnBeforePoint(1)).isFalse();
    }

    @Test
    void lineUnDrawTest() {
        Line line = new Line(participantsCount, unDrawLineRandomMock());

        IntStream.range(0, participantsCount)
            .forEach(position -> assertThat(line.hasLine(position)).isFalse());
    }


    private Random drawLineRandomMock() {
        return new Random() {
            @Override
            public boolean nextBoolean() {
                return true;
            }
        };
    }

    private Random unDrawLineRandomMock() {
        return new Random() {
            @Override
            public boolean nextBoolean() {
                return false;
            }
        };
    }
}