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
        String rewards = "0,0,1000,0,3000";

        List<Line> lines = new ArrayList<>();
        for(int i = 0; i < HEIGHT; i++) {
            lines.add(Line.of(names.split(",").length));
        }

        ladder = Ladder.of(names, rewards, lines);
        assertThat(ladder).isEqualTo(Ladder.of(names, rewards, lines));
    }
}
