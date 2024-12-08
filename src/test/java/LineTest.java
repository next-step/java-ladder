import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void chaining() {
        Line line = new Line(0, Arrays.asList(true, false, false, true));

        assertThat(line.move(0)).isEqualTo(new Pos(1, 1));
        assertThat(line.move(1)).isEqualTo(new Pos(0, 1));
        assertThat(line.move(2)).isEqualTo(new Pos(2, 1));
        assertThat(line.move(3)).isEqualTo(new Pos(4, 1));
    }
}
