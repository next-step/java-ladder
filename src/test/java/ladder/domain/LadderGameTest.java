package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    @DisplayName("사다리게임 사다리 생성")
    void createLadder() {
        List<String> users = Arrays.asList("a", "b", "c");
        List<String> outcomes = Arrays.asList("1", "2", "3");
        LadderRecord ladderRecord = new LadderRecord(users, outcomes);
        int height = 5;
        LadderGame ladderGame = new LadderGame();
        Ladder ladder = ladderGame.createLadder(ladderRecord, height);

        assertThat(ladder.getHeight()).isEqualTo(height);
        assertThat(ladder.getLines()).hasSize(height);
    }
}
