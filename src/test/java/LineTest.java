import domain.Line;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void oneLine() {
        Line line = new Line(5);
        assertThat(line.numberOfTruePoints()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void move() {
        Line line = new Line(Arrays.asList(true, false, false));
        assertThat(line.move(0)).isEqualTo(1);

        line = new Line(Arrays.asList(false, false, true));
        assertThat(line.move(0)).isEqualTo(0);
        assertThat(line.move(1)).isEqualTo(1);
        assertThat(line.move(2)).isEqualTo(3);
    }
}
