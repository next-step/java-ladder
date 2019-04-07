import domain.Line;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void generateLine() {
        Line line = new Line(5);
        assertThat(numberOfTrue(line.points)).isGreaterThanOrEqualTo(1);
    }

    private int numberOfTrue(List<Boolean> list) {
        int sum = 0;
        for(boolean b : list) {
            sum += b ? 1 : 0;
        }
        return sum;
    }


}
