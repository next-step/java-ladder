package ladder;

import ladder.domain.LadderBoard;
import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.domain.Point;
import ladder.dto.LadderGameRequest;
import ladder.view.ResultView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
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
