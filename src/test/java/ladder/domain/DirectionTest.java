package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    void valueOfCharacter() {
        assertThat(Direction.valueOfCharacter("|")).isEqualTo(Direction.VERTICAL);
        assertThat(Direction.valueOfCharacter("-")).isEqualTo(Direction.HORIZONTAL);
        assertThat(Direction.valueOfCharacter(" ")).isEqualTo(Direction.NONE);
    }

    @Test
    void isHorizontal() {
        assertThat(Direction.HORIZONTAL.isHorizontal()).isTrue();
        assertThat(Direction.NONE.isNone()).isTrue();
    }
}
