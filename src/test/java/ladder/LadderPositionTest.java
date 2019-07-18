package ladder;

import ladder.domain.DirectionMoveState;
import ladder.domain.LadderLineDirection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderPositionTest {
    private static final int VALUE_OF_POSITION_ONE = 1;

    @DisplayName("처음 포지션은 index가 0이며, 왼쪽 움직임이 불가능합니다.")
    @Test
    public void testFirstPositionIsIndexZeroAndLeftMoveImpossible() {
        LadderPosition ladderPosition = LadderPosition.first();

        LadderPosition rightPossiblePosition
                = LadderPosition.of(0, LadderLineDirection.of(DirectionMoveState.IMPOSSIBLE, DirectionMoveState.POSSIBLE));
        LadderPosition rightImpossiblePosition
                = LadderPosition.of(0, LadderLineDirection.of(DirectionMoveState.IMPOSSIBLE, DirectionMoveState.IMPOSSIBLE));

        LadderPosition[] matchedPosition = {
                rightPossiblePosition,
                rightImpossiblePosition
        };

        assertThat(matchedPosition).containsAnyOf(ladderPosition);
    }

    @DisplayName("마지막 포지션은 오른쪽 움직임이 불가능 해야 합니다.")
    @Test
    public void testLastPositionIsRightMoveImpossible() {
        LadderPosition currentPosition
                = LadderPosition.of(2, LadderLineDirection.of(DirectionMoveState.IMPOSSIBLE, DirectionMoveState.POSSIBLE));

        LadderPosition lastPosition = currentPosition.moveToLast();

        LadderPosition expectedLastPosition =
                LadderPosition.of(3, LadderLineDirection.of(DirectionMoveState.POSSIBLE, DirectionMoveState.IMPOSSIBLE));

        assertThat(lastPosition).isEqualTo(expectedLastPosition);
    }

    @DisplayName("양 쪽으로 이동할 수 없는 조건에서의 다음 포지션은 현재 포지션과 같습니다.")
    @Test
    public void testIfImpossibleMovePositionThenEqualsCurrentIndexAndNextIndex() {
        int beginPosition = 1;
        LadderLineDirection ladderLineDirection = LadderLineDirection.of(DirectionMoveState.IMPOSSIBLE, DirectionMoveState.IMPOSSIBLE);
        LadderPosition ladderPosition = LadderPosition.of(beginPosition, ladderLineDirection);

        int nextPosition = ladderPosition.computeNextPosition();
        assertThat(nextPosition).isEqualTo(beginPosition);
    }

    @DisplayName("왼쪽으로 이동할 때의 포지션 값을 검증합니다.")
    @Test
    public void testIsValidPositionValueWhenMoveToLeft() {
        int beginPosition = 2;
        LadderPosition position
                = LadderPosition.of(beginPosition, LadderLineDirection.of(DirectionMoveState.POSSIBLE, DirectionMoveState.IMPOSSIBLE));

        int expectedNextPosition = beginPosition - VALUE_OF_POSITION_ONE;
        assertThat(position.computeNextPosition()).isEqualTo(expectedNextPosition);
    }

    @DisplayName("오른쪽으로 이동할 때의 포지션 값을 검증합니다.")
    @Test
    public void testIsValidPositionValueWhenMoveToRight() {
        int beginPosition = 2;
        LadderPosition position
                = LadderPosition.of(beginPosition, LadderLineDirection.of(DirectionMoveState.IMPOSSIBLE, DirectionMoveState.POSSIBLE));

        int expectedNextPosition = beginPosition + VALUE_OF_POSITION_ONE;
        assertThat(position.computeNextPosition()).isEqualTo(expectedNextPosition);
    }
}
