package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HeightTest {

    @Test
    void create_height_success() {
        assertThatCode(() -> new Height(2)).doesNotThrowAnyException();
    }

    @Test
    void create_height_fail() {
        assertThatThrownBy(() -> new Height(0)).isInstanceOf(IllegalArgumentException.class);
    }
}