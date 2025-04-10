package nextstep.ladder.line;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    public void size() {
        assertThatThrownBy(() -> new Line(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
