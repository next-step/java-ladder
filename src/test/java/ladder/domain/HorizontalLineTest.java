package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class HorizontalLineTest {

    @Test
    void addTest() {
        assertThat(new HorizontalLine(3, () -> true)).isEqualTo(new HorizontalLine(List.of(true, true)));
    }

    @Test
    void nonAddTest() {
        assertThat(new HorizontalLine(4, () -> false)).isEqualTo(
            new HorizontalLine(List.of(false, false, false)));
    }

}
