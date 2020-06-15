package ladder.domain.ladder;

import ladder.domain.ladder.ladderInfo.LadderHeight;
import ladder.domain.player.LadderPlayers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesCreatorTest {

    private String[] playerNames;

    @BeforeEach
    void init() {
        this.playerNames = new String[]{"pobi", "honux", "po", "bi"};
    }

    @Test
    @DisplayName("사다리가 정상적으로 만들어 지는지 테스트")
    void LadderCreator_성공_Test() {
        LadderPlayers ladderPlayers = LadderPlayers.participate(playerNames);
        LadderHeight ladderHeight = LadderHeight.inputHeight(5);

        Lines lines = LinesCreator.create(ladderPlayers.getPlayerCount(), ladderHeight);

        assertThat(lines).isNotNull();
    }
}
