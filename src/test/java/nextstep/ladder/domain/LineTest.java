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
            .forEach(position -> assertThat(line.get(position)).isFalse());
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
    @DisplayName("왼쪽 이동 기능이 잘 동작한다.")
    void hasLeftLineTest() {
        Line line = new Line(3, drawLineRandomMock());
        // true, false, true
        /* 0     1      2     3
           |-----|      |-----|
         */

        assertThat(line.hasLeft(0)).isFalse();
        assertThat(line.hasLeft(3)).isTrue();
        assertThat(line.hasLeft(5)).isFalse();
    }

    @Test
    @DisplayName("오른쪽 이동 기능이 잘 동작한다.")
    void hasRightLineTest() {
        Line line = new Line(3, drawLineRandomMock());
        // true, false, true
        /* 0     1      2     3
           |-----|      |-----|
         */

        assertThat(line.hasRight(0)).isTrue();
        assertThat(line.hasRight(3)).isFalse();
        assertThat(line.hasRight(100)).isFalse();
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