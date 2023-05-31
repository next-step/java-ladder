package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class DirectionTest {

    @DisplayName("사다리게임은 양방향으로 진행할 수 없다.")
    @Test
    void 객체가_양방향_진행가능으로_생성된_경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Direction.create(true, true))
                .withMessageMatching("양방향으로 진행할 수 없습니다.");
    }

    @DisplayName("사다리_첫번째라인_Direction객체 생성")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void 첫번째_Direction객체_생성(boolean input) {
        Direction direction = Direction.createFirst(input);
        assertThat(direction).isEqualTo(Direction.create(false, input));
    }

    @DisplayName("다음_위치의_Direction객체 생성")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void 다음_위치의_Direction객체(boolean input) {
        Direction currentDirection = Direction.create(false, false);
        Direction nextDirection = currentDirection.createNext(input);
        assertThat(nextDirection).isEqualTo(Direction.create(false, input));
    }

    @DisplayName("사다리_마지막라인_Direction객체 생성")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void 마지막_Direction객체_생성(boolean input) {
        Direction direction = Direction.create(false, input);
        Direction lastDirection = direction.createLast();
        assertThat(lastDirection).isEqualTo(Direction.create(direction.canMoveToRight(), false));
    }
}

