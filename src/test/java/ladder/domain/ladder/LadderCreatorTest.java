package ladder.domain.ladder;

import ladder.domain.player.LadderPlayers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderCreatorTest {

    @Test
    void LadderCreator_높이값_0보다작음_Test() {
        String[] playerNames = {"pobi","honux","po","bi"};
        LadderPlayers ladderPlayers = LadderPlayers.participate(playerNames);
        int height = -1;

        assertThatThrownBy(() -> LadderCreator.create(ladderPlayers, height))
                .hasMessageMatching("높이는 1보다 작을 수 없습니다.");
    }

    @Test
    void LadderCreator_성공_Test() {
        String[] playerNames = {"pobi","honux","po","bi"};
        LadderPlayers ladderPlayers = LadderPlayers.participate(playerNames);
        int height = 5;

        LadderCreator ladderCreator = LadderCreator.create(ladderPlayers, height);
        assertThat(ladderCreator).isNotNull();
    }
}
