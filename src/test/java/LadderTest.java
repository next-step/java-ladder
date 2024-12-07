import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void move() {
        List<Line> lines = new ArrayList<>();

        lines.add(new Line(0, Arrays.asList(true, false, false)));
        lines.add(new Line(1, Arrays.asList(true, false, false)));

        assertThat(new Ladder(lines, "a,b,c,d".split(","), "a,b,c,d".split(",")).move(0)).isEqualTo(new Pos(0, 2));
    }

    @Test
    void travelAll() {
        List<Line> lines = new ArrayList<>();

        lines.add(new Line(0, Arrays.asList(true, false, false)));
        lines.add(new Line(1, Arrays.asList(true, false, false)));

        List<TravelResult> results = new Ladder(lines, "a,b,c,d".split(","), "a,b,c,d".split(",")).travelAll();

        assertThat(results).hasSize(4);
        assertThat(results.get(0)).isNotEqualTo(results.get(1));
        assertThat(results.get(0)).isNotEqualTo(results.get(2));
        assertThat(results.get(0)).isNotEqualTo(results.get(3));
    }
}
