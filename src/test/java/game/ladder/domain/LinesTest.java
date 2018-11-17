package game.ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @Test
    public void 만들기() {
        List<Line> inputs = Arrays.asList(new Line(3));
        Lines lines = new Lines(inputs);

        assertThat(lines.getHeight()).isEqualTo(new Height(inputs.size()));
    }

}