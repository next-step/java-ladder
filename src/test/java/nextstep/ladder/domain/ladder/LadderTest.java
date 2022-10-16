package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @DisplayName("높이만큼 라인이 생성된다.")
    @Test
    void ladder() {
        Players players = Players.create("test1", "test2", "test3");
        Ladder ladder = Ladder.create(5, players, () -> true);

        assertThat(ladder.lines()).hasSize(5);
    }

    @DisplayName("사다리 높이가 1 미만인 경우 예외가 발생한다.")
    @Test
    void ladderHeightException() {
        Players players = Players.create("test1", "test2", "test3");
        assertThatThrownBy(() -> Ladder.create(0, players, () -> true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시작 포인트의 끝 위치를 알 수 있다.")
    @Test
    void pointPosition() {
        /**
         *  |-----|     |
         *  |-----|     |
         */
        List<Point> pointsA = List.of(new Point(0, false, true),
                new Point(1, true, false),
                new Point(2, false, false));
        List<Point> pointsB = List.of(new Point(0, false, true),
                new Point(1, true, false),
                new Point(2, false, false));
        Line lineA = new Line(pointsA);
        Line lineB = new Line(pointsB);
        Ladder ladder = new Ladder(List.of(lineA, lineB));

        assertThat(ladder.destinationPosition(0)).isEqualTo(0);
        assertThat(ladder.destinationPosition(1)).isEqualTo(1);
        assertThat(ladder.destinationPosition(2)).isEqualTo(2);
    }
}
