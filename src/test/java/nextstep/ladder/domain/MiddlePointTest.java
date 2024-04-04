package nextstep.ladder.domain;

import nextstep.ladder.data.MoveDirection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MiddlePointTest {

    @DisplayName("현재 위치에서 왼쪽으로 이동한 결과를 반환한다.")
    @Test
    void returnMoveToLeft() {
        // given
        Point point = MiddlePoint.create(MoveDirection.RIGHT, MoveDirection.LEFT);

        // then
        assertThat(point.movePosition(8))
                .isEqualTo(7);
    }

    @DisplayName("현재 위치에서 아래로 이동한 결과를 반환한다.")
    @Test
    void returnMoveToStay() {
        // given
        Point point = MiddlePoint.create(MoveDirection.STAY, MoveDirection.STAY);

        // then
        assertThat(point.movePosition(8))
                .isEqualTo(8);
    }

    @DisplayName("현재 위치에서 오른쪽으로 이동한 결과를 반환한다.")
    @Test
    void returnMoveToRight() {
        // given
        Point point = MiddlePoint.create(MoveDirection.STAY, MoveDirection.RIGHT);

        // then
        assertThat(point.movePosition(8))
                .isEqualTo(9);
    }

    @DisplayName("이전 방향이 왼쪽을 가리키고 있으면, 왼쪽을 가리키지 못한다.")
    @Test
    void cantDirectLeftIfBeforeLeft() {
        // then
        assertThatThrownBy(() -> MiddlePoint.create(MoveDirection.LEFT, MoveDirection.LEFT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이전 방향이 아래를 가리키고 있으면, 왼쪽을 가리키지 못한다.")
    @Test
    void cantDirectLeftIfBeforeStay() {
        // then
        assertThatThrownBy(() -> MiddlePoint.create(MoveDirection.STAY, MoveDirection.LEFT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이전 방향이 오른쪽을 가리키고 있으면, 아래를 가리키지 못한다.")
    @Test
    void cantDirectStayIfBeforeRight() {
        // then
        assertThatThrownBy(() -> MiddlePoint.create(MoveDirection.RIGHT, MoveDirection.STAY))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이전 방향이 오른쪽을 가리키고 있으면, 오른쪽을 가리키지 못한다.")
    @Test
    void cantDirectRightIfBeforeRight() {
        // then
        assertThatThrownBy(() -> MiddlePoint.create(MoveDirection.RIGHT, MoveDirection.RIGHT))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
