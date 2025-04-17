package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("사다리 라인 생성 테스트: 길이 양쪽에 생길 수 없다.")
    void createTest() {
        var playerCount = 5;
        var trueLine = new Line(playerCount, new TrueRandom());

        Assertions.assertThat(trueLine.getPoints()).isEqualTo(List.of(true, false, true, false));
    }

    static class TrueRandom extends Random {
        @Override
        public boolean nextBoolean() {
            return true;
        }
    }

    @Test
    @DisplayName("cursor가 0일 때 오른쪽으로 이동")
    void calculateNextPosition_cursorAtStart_movesRight() {
        // given
        var points = List.of(true, false, false);
        var line = new Line(points);

        // when
        int nextPosition = line.calculateNextPosition(0);

        // then
        assertThat(nextPosition).isEqualTo(1);
    }

    @Test
    @DisplayName("cursor가 마지막 위치일 때 왼쪽으로 이동")
    void calculateNextPosition_cursorAtEnd_movesLeft() {
        // given
        var points = List.of(false, false, true);
        var line = new Line(points);

        // when
        int nextPosition = line.calculateNextPosition(2);

        // then
        assertThat(nextPosition).isEqualTo(1);
    }

    @Test
    @DisplayName("cursor가 중간에 있을 때 왼쪽으로 이동")
    void calculateNextPosition_cursorInMiddle_movesLeft() {
        // given
        var points = List.of(false, true, false);
        var line = new Line(points);

        // when
        int nextPosition = line.calculateNextPosition(2);

        // then
        assertThat(nextPosition).isEqualTo(1);
    }

    @Test
    @DisplayName("cursor가 중간에 있을 때 오른쪽으로 이동")
    void calculateNextPosition_cursorInMiddle_movesRight() {
        // given
        var points = List.of(false, false, true);
        var line = new Line(points);

        // when
        int nextPosition = line.calculateNextPosition(1);

        // then
        assertThat(nextPosition).isEqualTo(2);
    }

    @Test
    @DisplayName("cursor가 이동하지 않음")
    void calculateNextPosition_cursorDoesNotMove() {
        // given
        var points = List.of(false, false, false);
        var line = new Line(points);

        // when
        int nextPosition = line.calculateNextPosition(1);

        // then
        assertThat(nextPosition).isEqualTo(1);
    }
}
