package domain;

import ladder.domain.DirectionMoveState;
import ladder.domain.LadderLineDirection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class LadderLineDirectionTest {

    @DisplayName("방향 데이터가 같은 인스턴스는 동등한 인스턴스인지 테스트 합니다.")
    @Test
    public void testInstanceIs() {
        LadderLineDirection ladderLineDirection1
                = LadderLineDirection.of(DirectionMoveState.POSSIBLE, DirectionMoveState.IMPOSSIBLE);

        LadderLineDirection ladderLineDirection2
                = LadderLineDirection.of(DirectionMoveState.POSSIBLE, DirectionMoveState.IMPOSSIBLE);

        assertThat(ladderLineDirection1).isEqualTo(ladderLineDirection2);
    }

    @DisplayName("양방향이 가능한 경우는 존재하지 않습니다. 만일 양방향이라면, 예외를 발생합니다.")
    @Test
    public void testIfBothSideMovePossibleThenInvokeException() {
        assertThatIllegalStateException()
                .isThrownBy(() -> LadderLineDirection.of(DirectionMoveState.POSSIBLE, DirectionMoveState.POSSIBLE));
    }

    @DisplayName("첫번째 방향의 왼쪽 움직임은 항상 불가능해야 합니다.")
    @Test
    public void testFirstDirectionShouldBeLeftImpossible() {
        LadderLineDirection firstLineDirection = LadderLineDirection.first();
        assertThat(firstLineDirection.isLeftGo()).isFalse();
    }

    @DisplayName("마지막 방향의 오른쪽 움직임은 항상 불가능 합니다.")
    @Test
    public void testLastDirectionShouldBeRightImpossible() {
        LadderLineDirection previousLineDirection
                = LadderLineDirection.of(DirectionMoveState.IMPOSSIBLE, DirectionMoveState.POSSIBLE);

        LadderLineDirection lastLineDirection = previousLineDirection.last();

        assertThat(lastLineDirection.isRightGo()).isFalse();
    }

    @DisplayName("이전 방향이 움직이기 가능한 방향이면 다음 방향은 반드시 움직이지 못하는 방향이여야 합니다.")
    @Test
    public void testIfPreviousMoveStatePossibleThenNextMoveStateShouldBeImpossible() {
        LadderLineDirection firstLineDirection = LadderLineDirection.of(DirectionMoveState.IMPOSSIBLE, DirectionMoveState.POSSIBLE);

        LadderLineDirection actuallyDirection = firstLineDirection.next();
        LadderLineDirection expectedDirection = LadderLineDirection.of(DirectionMoveState.POSSIBLE, DirectionMoveState.IMPOSSIBLE);

        assertThat(actuallyDirection).isEqualTo(expectedDirection);
    }
}
