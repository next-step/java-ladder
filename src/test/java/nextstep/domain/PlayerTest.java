package nextstep.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    void create_More_Than_Five_Letters_Name() {
        assertThatThrownBy(() -> new Player("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
