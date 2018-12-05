package ladder.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private static final int HEIGHT = 5;
    private static Ladder ladder;

    @Test
    public void 사다리_만들기() {
        int countOfPerson = 5;

        List<Line> lines = new ArrayList<>();

        for(int i = 0; i < HEIGHT; i++) {
            lines.add(Line.of(countOfPerson));
        }

        ladder = Ladder.of(lines);
        assertThat(ladder).isEqualTo(Ladder.of(lines));
        assertThat(ladder.size()).isEqualTo(5);
    }

    @Test
    public void 사다리_만들기_랜덤() {
        int countOfPerson = 5;

        ladder = Ladder.of(countOfPerson, HEIGHT);
        assertThat(ladder.size()).isEqualTo(5);
    }
}
