package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void generateLineByCountOfPerson() {
        int countOfPerson = 4;
        Line line = new Line(countOfPerson);

        assertThat(line.getWidth()).isEqualTo(countOfPerson);
    }
}
