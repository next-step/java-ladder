package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("포지션 생성")
    void create() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(new Position(1));
    }

}