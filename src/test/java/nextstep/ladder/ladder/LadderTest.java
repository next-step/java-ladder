package nextstep.ladder.ladder;

import nextstep.ladder.ladder.dto.LadderResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("사다리 게임 플레이")
    @Test
    void test() {
        LadderLine first = LadderLine.of(
                Arrays.asList(right(0), left(1), straight(2))
        );
        LadderLine second = LadderLine.of(
                Arrays.asList(straight(0), right(1), left(2))
        );
        LadderLine third = LadderLine.of(
                Arrays.asList(right(0), left(1), straight(2))
        );

        Ladder ladder = new Ladder(3, Arrays.asList(first, second, third));
        LadderResult ladderResult = ladder.play();

        assertThat(ladderResult.getTarget(0)).isEqualTo(2);
        assertThat(ladderResult.getTarget(1)).isEqualTo(1);
        assertThat(ladderResult.getTarget(2)).isZero();
    }

    private Point right(int position) {
        return new Point(position, Direction.of(FALSE, TRUE));
    }

    private Point left(int position) {
        return new Point(position, Direction.of(TRUE, FALSE));
    }

    private Point straight(int position) {
        return new Point(position, Direction.of(FALSE, FALSE));
    }
}