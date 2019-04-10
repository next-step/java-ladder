package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    @Test(expected = IllegalArgumentException.class)
    public void 왼쪽_이동과_오른쪽_이동_모두_가능한_경우() {
        // given
        // when
        // then
        Direction.of(true, true);
    }

    @Test
    public void 첫_번째_칸의_방향() {
        // given
        // when
        final Direction direction = Direction.first(true);

        // then
        assertThat(direction).isEqualTo(Direction.of(false, true));
    }

    @Test
    public void 마지막_칸의_방향() {
        // given
        // when
        final Direction direction = Direction.last(true);

        // then
        assertThat(direction).isEqualTo(Direction.of(true, false));
    }
}