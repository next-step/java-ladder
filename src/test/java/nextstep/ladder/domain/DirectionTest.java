package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import nextstep.ladder.generator.FixedNonProductionGenerator;
import nextstep.ladder.generator.FixedProductionGenerator;
import nextstep.ladder.generator.RandomProductionGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {
    @Test
    @DisplayName("방향에 대한 객체 생성을 확인한다")
    void checkedDirectionObjectGenerate() {
        // given
        boolean right = true;

        // when
        Direction direction = Direction.first(right);

        // then
        assertAll(
                () -> assertThat(direction.isLeft()).isFalse(),
                () -> assertThat(direction.isRight()).isTrue()
        );
    }

    @Test
    @DisplayName("이전 위치에 사다리가 생성된 경우, 다음 사다리 생성을 확인한다")
    void checkedNextDirection() {
        // given
        Direction direction = Direction.first(true);

        // when
        Direction nextDirection = direction.next(new RandomProductionGenerator());

        // then
        assertAll(
                () -> assertThat(nextDirection.isLeft()).isTrue(),
                () -> assertThat(nextDirection.isRight()).isFalse()
        );
    }

    @Test
    @DisplayName("이전 위치에 사다리 생성이 되지 않은 경우, 다음 사다리 생성이 된것을 확인한다")
    void checkedNextDirectionFixedGenerate() {
        // given
        Direction direction = Direction.first(false);

        // when
        Direction nextDirection = direction.next(new FixedProductionGenerator());

        // then
        assertAll(
                () -> assertThat(nextDirection.isLeft()).isFalse(),
                () -> assertThat(nextDirection.isRight()).isTrue()
        );
    }

    @Test
    @DisplayName("이전 위치에 사다리 생성이 되지 않은 경우, 다음 사다리 생성 되지 않은 것을 확인한다")
    void checkedNextDirectionFixedNonGenerate() {
        // given
        Direction direction = Direction.first(false);

        // when
        Direction nextDirection = direction.next(new FixedNonProductionGenerator());

        // then
        assertAll(
                () -> assertThat(nextDirection.isLeft()).isFalse(),
                () -> assertThat(nextDirection.isRight()).isFalse()
        );
    }

    @Test
    @DisplayName("마지막 위치의 사다리 생성을 확인한다")
    void checkedLastDirectionGenerate() {
        // given
        Direction direction = Direction.first(true);

        // when
        Direction lastDirection = direction.last();

        // then
        assertAll(
                () -> assertThat(lastDirection.isLeft()).isTrue(),
                () -> assertThat(lastDirection.isRight()).isFalse()
        );
    }

    @Test
    @DisplayName("해당 위치에서 사다리가 양쪽으로 생성되는 경우, 예외처리를 한다")
    void exceptionLeftAndRightLineGenerate() {
        // given
        boolean left = true;
        boolean right = true;

        // when & then
        assertThatThrownBy(() -> Direction.of(left, right))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
