package domain.ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void generate_line() {
        int userCount = 3;

        Line line = new Line();
        line.generate(userCount);
        assertThat(line.size()).isEqualTo(userCount);
    }
}
