package nextstep.laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void create() {
        Direction direction = Direction.from(1);
        Assertions.assertThat(direction).isNotNull();
    }
}