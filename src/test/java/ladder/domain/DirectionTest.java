package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    @DisplayName("왼쪽, 오른쪽 중 하나의 방향만 가질 수 있음")
    void canNotHaveTwoWay() {
        // given when then
        Assertions.assertThatIllegalStateException()
                .isThrownBy(() -> new Direction(true, true))
                .withMessageMatching("한 쪽의 방향만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("Direction 정상생성")
    void crate() {
        // given when
        Direction direction = new Direction(true, false);

        // then
        assertThat(direction.isLeft()).isTrue();
        assertThat(direction.isRight()).isFalse();
    }

    @Test
    @DisplayName("첫 번째 방향은 왼쪽라인을 가지고 있지 않음.")
    void firstDirection() {
        // given
        Direction first = Direction.first(true);

        // when then
        assertThat(first.isLeft()).isFalse();
    }

}