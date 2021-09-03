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
        Direction direction0 = Direction.first(() -> false);
        Direction direction1 = Direction.next(direction0, () -> false);

        // then
        assertThat(direction1).isEqualTo(Direction.next(direction0, () -> false));
        assertThat(direction0.left()).isFalse();
    }

    @Test
    @DisplayName("last Direction 생성")
    void create_last() {
        // when
        Direction direction0 = Direction.first(() -> false);
        Direction direction1 = Direction.last(direction0);

        // then
        assertThat(direction1).isEqualTo(Direction.last(direction0));
        assertThat(direction1.left()).isFalse();
        assertThat(direction1.right()).isFalse();
    }

    @Test
    @DisplayName("중간 Direction 생성")
    void create() {
        // when
        Direction direction0 = Direction.first(() -> false);
        Direction direction1 = Direction.next(direction0, () -> false);

        // then
        assertThat(direction1).isEqualTo(Direction.next(direction0, () -> false));
        assertThat(direction1.left()).isFalse();
    }

    @Test
    @DisplayName("Direction 생성 실패 : true, true")
    void create_fail() {
        // given
        Direction direction = Direction.first(() -> true);
        // when, then
        assertThatThrownBy(() -> Direction.next(direction, () -> true))
                .isInstanceOf(CustomException.class);
    }

    @Test
    @DisplayName("first Direction 생성")
    void create_first2() {
        // when
        Direction direction = Direction.first(() -> false).next(() -> false);

        // then
        assertThat(direction).isEqualTo(Direction.of(false, false));
        assertThat(direction.left()).isFalse();
    }

    @Test
    @DisplayName("last Direction 생성")
    void create_last2() {
        // when
        Direction direction = Direction.first(() -> true).last();

        // then
        assertThat(direction).isEqualTo(Direction.of(false, true).last());
        assertThat(direction.left()).isTrue();
        assertThat(direction.right()).isFalse();
    }

    @Test
    @DisplayName("중간 Direction 생성")
    void create2() {
        // when
        Direction direction0 = Direction.first(() -> false);
        Direction direction1 = direction0.next(() -> false);

        // then
        assertThat(direction1).isEqualTo(Direction.of(false, false));
        assertThat(direction1.left()).isFalse();
    }

    @Test
    @DisplayName("Direction 생성 실패 : true, true")
    void create_fail2() {
        // given
        Direction direction = Direction.first(() -> true);
        // when, then
        assertThatThrownBy(() -> Direction.next(direction, () -> true))
                .isInstanceOf(CustomException.class);
    }

}