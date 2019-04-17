import domain.Ladder;
import domain.Line;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderTest {

    @Test
    public void numberOfLinesInLadder() {
        Ladder ladder = new Ladder(3,5);
        assertThat(ladder.getNumberOfLines()).isEqualTo(3);
    }

    @Test
    public void move() {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(true,false,false)));
        lines.add(new Line(Arrays.asList(false,true,false)));
        lines.add(new Line(Arrays.asList(false,false,true)));

        Ladder ladder = new Ladder(lines);
        assertThat(ladder.move(0)).isEqualTo(3);
        assertThat(ladder.move(1)).isEqualTo(0);
        assertThat(ladder.move(2)).isEqualTo(1);
        assertThat(ladder.move(3)).isEqualTo(2);

    }
}
