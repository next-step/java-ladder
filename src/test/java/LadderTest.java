
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void create() {
        String[] playerNames = "pobi,crong,honux".split(",");

        List<Line> lines = new ArrayList<>();

        lines.add(new Line(DotType.NODE, DotType.EMPTY, DotType.NODE));
        lines.add(new Line(DotType.NODE, DotType.BRIDGE, DotType.NODE));
        lines.add(new Line(DotType.NODE, DotType.EMPTY, DotType.NODE));

        assertThat(new Ladder(playerNames, lines)).isEqualTo(new Ladder(playerNames, lines));
    }
}
