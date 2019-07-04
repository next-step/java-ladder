package ladder.domain.ladderline;

import ladder.domain.model.Direction;
import ladder.domain.model.Index;
import ladder.domain.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadderLineRuleTest {

    @Test
    @DisplayName("이전 포인트에서 오른쪽 방향으로 선이 없는 경우")
    void checkLineRule() {
        Point prevPoint = Point.of(Index.of(0), Direction.of(false, false));
        LadderLineRule ladderLineRule = LadderLineRule.of(() -> true, prevPoint, Index.of(1), 5);
        Point currentPoint = ladderLineRule.makePoint();
        assertThat(currentPoint.getIndex().get()).isEqualTo(1);
        assertFalse(currentPoint.isLeft());
    }

    @Test
    @DisplayName("이전 포인트에서 오른쪽 방향으로 선이 있는 경우")
    void checkLineRule2() {
        Point prevPoint = Point.of(Index.of(0), Direction.of(false, true));
        LadderLineRule ladderLineRule = LadderLineRule.of(() -> true, prevPoint, Index.of(1), 5);
        Point currentPoint = ladderLineRule.makePoint();
        assertThat(currentPoint.getIndex().get()).isEqualTo(1);
        assertTrue(currentPoint.isLeft());
    }

    @Test
    @DisplayName("마지막 포인트인 경우")
    void checkLineRule3() {
        Point prevPoint = Point.of(Index.of(3), Direction.of(false, false));
        LadderLineRule ladderLineRule = LadderLineRule.of(() -> true, prevPoint, Index.of(4), 5);
        Point endPoint = ladderLineRule.makePoint();
        assertThat(endPoint.getIndex().get()).isEqualTo(4);
        assertFalse(endPoint.isRight());
    }
}
