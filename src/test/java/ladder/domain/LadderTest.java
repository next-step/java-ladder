package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 사다리생성_n명_높이n() {
        int countOfPersion = 3;
        int height = 3;
        Level level = Level.findLevel("middle");
        Ladder ladder = new Ladder(countOfPersion, level);
        int countOfLine = ladder.lineCount();
        assertThat(countOfLine).isEqualTo(3);
        assertThat(ladder.ladderHeight()).isEqualTo(10);
    }

    @Test
    public void 라인생성() {
        int countOfPersion = 3;
        int height = 3;
        Level level = Level.findLevel("middle");
        Ladder ladder = new Ladder(countOfPersion, level);
    }
}
