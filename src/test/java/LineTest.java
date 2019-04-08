import domain.Line;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void oneLine() {
        Line line = new Line(5);
        assertThat(line.numberOfTruePoints()).isGreaterThanOrEqualTo(1);
    }




}
