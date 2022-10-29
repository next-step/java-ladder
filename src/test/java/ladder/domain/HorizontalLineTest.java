package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HorizontalLineTest {

    @Test
    void shouldValidateline() {
        HorizontalLine horizontalLine = new HorizontalLine(List.of(new Direction()));

        assertThatThrownBy(() -> horizontalLine.validate(2)).isInstanceOf(IllegalArgumentException.class);
    }
}
