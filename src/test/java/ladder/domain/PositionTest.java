package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("Postion 객체를 생성할 수 있다.")
    @Test
    void create() {
        Position expect = new Position(0);

        Position actual = new Position(0);

        assertThat(actual).isEqualTo(expect);
    }
}