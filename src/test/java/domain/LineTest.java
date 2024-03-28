package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("")
    @Test
    void test() {
        Line line = new Line(5);
        assertThat(line).isNotNull();
    }
}
