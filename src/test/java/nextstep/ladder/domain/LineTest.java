package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import java.util.stream.IntStream;
import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    private final int participantsCount = 5;

    @Test
    @DisplayName("사다리타기 라인 생성시 라인이 겹치지 않아야 한다.")
    void lineDrawTest() {
        Line line = new Line(participantsCount, drawLineRandomMock());

        assertThat(line.isNotDrawnBeforePoint(1)).isFalse();
    }

    @Test
    @DisplayName("사다리타기 라인이 생성되지 않아야 한다.")
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