package ladder.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private static final int HEIGHT = 5;
    private static Ladder ladder;

    @Test
    public void 사다리_게임() {
        String names = "aa,bb,cc,dd,ee";

        List<Line> lines = new ArrayList<>();
        for(int i = 0; i < HEIGHT; i++) {
            lines.add(Line.of(names.split(",").length));
        }

        ladder = Ladder.of(names, lines);
        assertThat(ladder).isEqualTo(Ladder.of(names, lines));
    }
}
