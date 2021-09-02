package ladderrefactoring.domain.ladder;

import ladderrefactoring.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @Test
    @DisplayName("first Direction 생성 정적 팩토리")
    void create_first() {
        // when
        Direction direction0 = Direction.first(false);

        // then
        assertThat(direction0).isEqualTo(Direction.of(false, false));
        assertThat(direction0.left()).isFalse();
    }

    @Test
    @DisplayName("이전과 관련된 last Direction 생성 정적 팩토리")
    void create_last() {
        // when
        Direction direction0 = Direction.of(true, false);
        Direction direction1 = Direction.last(direction0);

        // then
        assertThat(direction1).isEqualTo(Direction.of(false, false));
        assertThat(direction1.left()).isFalse();
        assertThat(direction1.right()).isFalse();
    }

    @Test
    @DisplayName("이전과 관련된 Direction 생성 정적 팩토리")
    void create() {
        // when
        Direction direction0 = Direction.of(true, false);
        Direction direction1 = Direction.of(direction0, false);

        // then
        assertThat(direction0).isEqualTo(Direction.of(true, false));
        assertThat(direction1.left()).isFalse();
    }

    @Test
    @DisplayName("Direction 생성 실패 : true, true")
    void create_fail() {
        // when, then
        assertThatThrownBy(() -> Direction.of(true, true))
                .isInstanceOf(CustomException.class);
    }
}