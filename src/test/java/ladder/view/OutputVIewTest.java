package ladder.view;

import ladder.domain.LadderGame;
import org.junit.jupiter.api.Test;

public class OutputVIewTest {
    @Test
    void resultPrint() {
        LadderGame ladderGame = LadderGame.of("pobi,honux,crong,jk", "5", "꽝,5000,꽝,3000");
        OutputView.resultPrint(ladderGame);
    }

    @Test
    void gameResultPrint() {
        LadderGame ladderGame = LadderGame.of("pobi,honux,crong,jk", "5", "꽝,5000,꽝,3000");
        OutputView.resultPrint(ladderGame);

        OutputView.gameResultPrint(ladderGame, "all");
    }
}
