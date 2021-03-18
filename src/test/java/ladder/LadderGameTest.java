package ladder;

import ladder.domain.LadderBoard;
import ladder.domain.LadderGame;
import ladder.dto.LadderGameRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("LadderGame 생성 테스트")
    void create() {
        String[] names = new String[]{"pobi","honux","crong","jk","aa","ccc"};
        int height = 8;

        LadderGameRequest ladderGameRequest = new LadderGameRequest(names, height);
        LadderGame ladderGame = new LadderGame(ladderGameRequest);
        LadderBoard ladderBoard = ladderGame.ladderBoard();

        assertThat(ladderBoard.playerNameList()).contains("pobi");
        assertThat(ladderBoard.playerNameList().size()).isEqualTo(names.length);
        assertThat(ladderBoard.lineList().size()).isEqualTo(height);
    }

}
