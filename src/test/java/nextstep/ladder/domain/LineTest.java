package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
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

    @Test
    @DisplayName("일급콜렉션 객체의 List는 외부에서는 불변 리스트 이다.")
    void getPointsUnmodifiableCollectionTest() {
        Line line = new Line(participantsCount, unDrawLineRandomMock());

        List<Boolean> points = line.getPoints();

        assertThatExceptionOfType(UnsupportedOperationException.class)
            .isThrownBy(() -> points.add(true));
    }

    @Test
    @DisplayName("사다리 선에 따라, 정상적으로 이동한다.")
    void lineMoveTest() {
        Line line = new Line(3, drawLineRandomMock());
        // true, false, true
        /* 0     1      2     3
           |-----|      |-----|
         */

        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);

        assertThat(line.move(2)).isEqualTo(3);
        assertThat(line.move(3)).isEqualTo(2);
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