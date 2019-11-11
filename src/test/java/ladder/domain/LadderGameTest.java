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
        int height = 5;
        LadderGame ladderGame = new LadderGame();
        Ladder ladder = ladderGame.createLadder(users, height);

        assertThat(ladder.getHeight()).isEqualTo(height);
        assertThat(ladder.getWidth()).isEqualTo(users.size() - 1);
        assertThat(ladder.getLines()).hasSize(height);
    }
}
