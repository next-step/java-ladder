package my.project.step4.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created : 2020-12-11 오전 11:24
 * Developer : Seo
 */
class DirectionTest {

    @Test
    void first() {
        assertThat(Direction.first(Bridge.NONE)).isNotNull().isInstanceOf(Direction.class);
        assertThat(Direction.first(Bridge.CONNECTED)).isNotNull().isInstanceOf(Direction.class);

        assertThat(Direction.first(Bridge.NONE).isLeft()).isFalse();
        assertThat(Direction.first(Bridge.NONE).isRight()).isFalse();

        assertThat(Direction.first(Bridge.CONNECTED).isLeft()).isFalse();
        assertThat(Direction.first(Bridge.CONNECTED).isRight()).isTrue();
    }

    @Test
    void of() {
        assertThat(Direction.of(Bridge.NONE, Bridge.NONE).isLeft()).isFalse();
        assertThat(Direction.of(Bridge.NONE, Bridge.NONE).isRight()).isFalse();

        assertThat(Direction.of(Bridge.CONNECTED, Bridge.NONE).isLeft()).isTrue();
        assertThat(Direction.of(Bridge.NONE, Bridge.CONNECTED).isRight()).isTrue();
    }

    @Test
    void first_of() {
        assertThat(Direction.first(Bridge.NONE))
                .isEqualTo(Direction.of(Bridge.NONE, Bridge.NONE));
        assertThat(Direction.first(Bridge.CONNECTED))
                .isEqualTo(Direction.of(Bridge.NONE, Bridge.CONNECTED));
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> Direction.of(Bridge.CONNECTED, Bridge.CONNECTED))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void next_random_true() {
        assertThat(Direction.first(Bridge.CONNECTED).next())
                .isEqualTo(Direction.of(Bridge.CONNECTED, Bridge.NONE));
    }

    @Test
    void next_random_false() {
        for (int i = 0; i < 100; i++) {
            assertThat(Direction.first(Bridge.NONE).next())
                    .isEqualTo(Direction.of(Bridge.NONE, Bridge.CONNECTED));
        }
    }

    @Test
    void next_true() {
        assertThat(Direction.of(Bridge.CONNECTED, Bridge.NONE).next(Bridge.CONNECTED))
                .isEqualTo(Direction.of(Bridge.NONE, Bridge.CONNECTED));
    }

    @Test
    void next_false() {
        assertThat(Direction.of(Bridge.NONE, Bridge.CONNECTED).next(Bridge.NONE))
                .isEqualTo(Direction.of(Bridge.CONNECTED, Bridge.NONE));
    }

    @Test
    void last() {
        assertThat(Direction.first(Bridge.CONNECTED).last())
                .isEqualTo(Direction.of(Bridge.CONNECTED, Bridge.NONE));
    }
}
