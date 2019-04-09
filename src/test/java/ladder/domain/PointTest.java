package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void 첫_번째_점() {
        // given
        // when
        final Point point = Point.first(true);

        // then
        assertThat(point).isNotNull();
        assertThat(point.getIndex()).isEqualTo(0);
        assertThat(point.canMoveLeft()).isFalse();
        assertThat(point.canMoveRight()).isTrue();
    }

    @Test
    public void 마지막_점() {
        // given
        final Point first = Point.first(true);

        // when
        final Point point = first.last();

        // then
        assertThat(point).isNotNull();
        assertThat(point.getIndex()).isEqualTo(1);
        assertThat(point.canMoveLeft()).isTrue();
        assertThat(point.canMoveRight()).isFalse();
    }

    @Test
    public void 이동이_가능한_경우() {
        // given
        final Point point = Point.first(true);

        // when
        final int result = point.move();

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 이동이_가능하지_않는_경우() {
        // given
        final Point point = Point.first(false);

        // when
        final int result = point.move();

        // then
        assertThat(result).isEqualTo(0);
    }
}