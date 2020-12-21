package nextstep.laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DirectionTest {

    @Test
    void create() {
        Direction direction = Direction.from(1);
        assertThat(direction).isNotNull();
    }
}