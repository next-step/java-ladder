package ladderrefactoring.domain.ladder;

import ladderrefactoring.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @Test
    @DisplayName("first Direction 생성")
    void create_first() {
        // when
        Direction direction = Direction.first(() -> false);

        // then
        assertThat(direction).isEqualTo(Direction.of(false, false));
        assertThat(direction.left()).isFalse();
    }

    @Test
    @DisplayName("last Direction 생성")
    void create_last() {
        // when
        Direction direction = Direction.first(() -> true).last();

        // then
        assertThat(direction).isEqualTo(Direction.of(false, true).last());
        assertThat(direction.left()).isTrue();
        assertThat(direction.right()).isFalse();
    }

    @Test
    @DisplayName("중간 Direction 생성")
    void create_middle() {
        // when
        Direction direction = Direction.first(() -> false).next(() -> false);

        // then
        assertThat(direction).isEqualTo(Direction.of(false, false));
        assertThat(direction.left()).isFalse();
    }

    @Test
    @DisplayName("Direction 생성 실패 : true, true")
    void create_fail() {
        // when, then
        assertThatThrownBy(() -> Direction.of(true, true))
                .isInstanceOf(CustomException.class);
    }

}