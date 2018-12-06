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

        List<LadderLine> ladderLines = new ArrayList<>();

        for(int i = 0; i < HEIGHT; i++) {
            ladderLines.add(LadderLine.init(countOfPerson));
        }

        ladder = Ladder.of(ladderLines);
        assertThat(ladder).isEqualTo(Ladder.of(ladderLines));
        assertThat(ladder.size()).isEqualTo(5);
    }

    @Test
    public void 사다리_만들기_랜덤() {
        int countOfPerson = 5;

        ladder = Ladder.of(countOfPerson, HEIGHT);
        assertThat(ladder.size()).isEqualTo(5);
    }


}
