package nextstep.ladder.domain.common;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.domain.common.exception.InvalidCreateDirectionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("방향")
public class DirectionTest {

    @Test
    public void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    public void init_invalid() {
        Assertions.assertThrows(InvalidCreateDirectionException.class, () -> Direction.of(true, true));
    }

    @Test
    public void next_true() {
        final Direction next = Direction.of(true, false).next();
        assertThat(next.isLeft()).isFalse();
    }

    @Test
    public void next_false() {
        final Direction next = Direction.of(false, true).next();
        assertThat(next).isEqualTo(Direction.of(true, false));
    }

    @Test
    public void first() {
        final Direction first = Direction.first();
        assertThat(first.isLeft()).isFalse();
    }

    @Test
    public void last() {
        final Direction last = Direction.first().last();
        assertThat(last.isRight()).isFalse();
    }
}
