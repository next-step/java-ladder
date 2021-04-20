package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("next 테스트")
    void next(boolean write) {
        // given
        Direction emptyDirection = new Direction(false, false);
        Direction leftLineDirection = new Direction(true, false);
        Direction rightLineDirection = new Direction(false, true);

        // when
        Direction nextEmpty = emptyDirection.next(write);
        Direction nextLeft = leftLineDirection.next(write);
        Direction nextRight = rightLineDirection.next(write);

        // then
        assertAll(
                () -> {
                    assertThat(nextEmpty.isLeft()).isFalse();
                    assertThat(write).isEqualTo(nextEmpty.isRight());
                    assertThat(nextLeft.isLeft()).isFalse();
                    assertThat(write).isEqualTo(nextLeft.isRight());
                    assertThat(nextRight.isLeft()).isTrue();
                    assertThat(nextRight.isRight()).isFalse();
                }
        );
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("last 테스트")
    void last() {
        // given
        Direction emptyDirection = new Direction(false, false);
        Direction leftLineDirection = new Direction(true, false);
        Direction rightLineDirection = new Direction(false, true);

        // when
        Direction lastEmpty = emptyDirection.last();
        Direction lastLeft = leftLineDirection.last();
        Direction lastRight = rightLineDirection.last();

        // then
        assertAll(
                () -> {
                    assertThat(lastEmpty.isRight()).isFalse();
                    assertThat(lastLeft.isRight()).isFalse();
                    assertThat(lastRight.isRight()).isFalse();
                    assertThat(lastEmpty.isLeft()).isFalse();
                    assertThat(lastLeft.isLeft()).isFalse();
                    assertThat(lastRight.isLeft()).isTrue();
                }
        );
    }

}