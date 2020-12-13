package my.project.step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created : 2020-12-11 오전 11:22
 * Developer : Seo
 */
class PointTest {
    private final int NONE = 0;
    private final int MOVEx1 = 1;
    private final int MOVEx2 = 2;

    @Test
    void first() {
        assertThat(Point.first(Bridge.NONE)).isNotNull().isInstanceOf(Point.class);
        assertThat(Point.first(Bridge.CONNECTED)).isNotNull().isInstanceOf(Point.class);

        assertThat(Point.first(Bridge.NONE).present()).isEqualTo(NONE);
        assertThat(Point.first(Bridge.CONNECTED).present()).isEqualTo(NONE);
    }

    @Test
    void move() {
        assertThat(Point.first(Bridge.NONE).move()).isEqualTo(NONE);
        assertThat(Point.first(Bridge.CONNECTED).move()).isEqualTo(MOVEx1);
    }

    @Test
    void next() {
        assertThat(Point.first(Bridge.NONE).next().present()).isEqualTo(MOVEx1);
        assertThat(Point.first(Bridge.CONNECTED).next().present()).isEqualTo(MOVEx1);
    }

    @Test
    void next_stay() {
        assertThat(Point.first(Bridge.NONE).next(Bridge.NONE).move()).isEqualTo(MOVEx1);
    }

    @Test
    void next_left() {
        assertThat(Point.first(Bridge.CONNECTED).next().move()).isEqualTo(NONE);
        assertThat(Point.first(Bridge.CONNECTED).next(Bridge.NONE).move()).isEqualTo(NONE);
    }

    @Test
    void next_right() {
        assertThat(Point.first(Bridge.NONE).next().move()).isEqualTo(MOVEx2);
        assertThat(Point.first(Bridge.NONE).next(Bridge.CONNECTED).move()).isEqualTo(MOVEx2);
    }

    @Test
    void next_error() {
        assertThatThrownBy(() -> Point.first(Bridge.CONNECTED).next(Bridge.CONNECTED).move()).isInstanceOf(IllegalStateException.class);
    }
}
