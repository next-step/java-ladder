package domain.ladder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @Test
    public void 생성확인() {
        List<Line> line = new ArrayList<>();
        line.add(new Line(Arrays.asList(true, false, true)));
        Lines lines = new Lines(line);

        assertThat(lines.getLine().get(0)).isEqualTo(new Line(Arrays.asList(true, false, true)));
    }
}
