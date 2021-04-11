package nextstep.refactoring.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @Test
    @DisplayName("직선 방향")
    void straight() {
        assertThat(Direction.straight()).isEqualTo(Direction.of(false, false));
    }

    @Test
    @DisplayName("좌측 방향")
    void left() {
        assertThat(Direction.left()).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("우측 방향")
    void right() {
        assertThat(Direction.right()).isEqualTo(Direction.of(false, true));
    }

    @Test
    @DisplayName("양방향을 모두 가리키는 경우는 없다.")
    void cannotIndicateBothDirection() {
        assertThatThrownBy(() -> Direction.of(true, true)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("우측을 가리키고 있다면, 다음 방향은 반드시 좌측을 가리켜야 한다.")
    void shouldHaveToPointAtEachOther() {
        assertThat(Direction.right().next()).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("좌측 방향인지 확인한다.")
    void checkIsLeft() {
        assertThat(Direction.left().isLeft()).isTrue();
    }

    @Test
    @DisplayName("우측 방향인지 확인한다.")
    void checkIsRight() {
        assertThat(Direction.right().isRight()).isTrue();
    }

    @Test
    @DisplayName("직선 방향인지 확인한다.")
    void checkIsStraight() {
        assertThat(Direction.straight().isStraight()).isTrue();
    }
}
