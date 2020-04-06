package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void generateLineByCountOfPerson() {
        Line line = new Line(4);

        assertThat(line.getWidth()).isEqualTo(4);
    }
}
