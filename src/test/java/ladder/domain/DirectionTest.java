package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    public static final Direction direction1 = Direction.first(true);
    public static final Direction direction2 = direction1.next(false);
    public static final Direction direction3 = direction2.last();

    @Test
    @DisplayName("first 테스트")
    void first() {
        // given
        boolean right = true;

        // when
        Direction first = Direction.first(right);

        // then
        assertThat(first).isEqualTo(Direction.first(right));
    }

    @Test
    @DisplayName("next 테스트")
    void next() {
        // given
        boolean right = true;

        // when
        Direction first = Direction.first(right);
        Direction next = first.next(false);

        // then
        assertThat(next).isEqualTo(Direction.first(right).next(false));
    }

    @Test
    @DisplayName("last 테스트")
    void last() {
        // given
        boolean right = true;

        // when
        Direction first = Direction.first(right);
        Direction next = first.next(false);
        Direction last = next.last();

        // then
        assertThat(last).isEqualTo(Direction.first(right).next(false).last());
    }
}
