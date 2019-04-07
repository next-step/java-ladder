package domain.ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void generateLadder() {
        int ladderHeight = 5;
        int userCount = 3;
        Ladder ladder = new Ladder(ladderHeight, userCount);
        int result = ladder.size();
        assertThat(result).isEqualTo(ladderHeight);
    }
}
