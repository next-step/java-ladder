package ladder.view;

import ladder.domain.LadderGame;
import org.junit.jupiter.api.Test;

public class OutputVIewTest {
//    @Test
//    void resultPrint() {
//        LadderGame ladderGame = new LadderGame("pobi,honux,crong,jk", "5", "꽝,5000,꽝,3000");
//        OutputView.resultPrint(ladderGame);
//    }

    @Test
    void gameResultPrint() {
        LadderGame ladderGame = new LadderGame("pobi,honux,crong,jk", "5", "꽝,5000,꽝,3000");
        OutputView.resultPrint(ladderGame);

        OutputView.gameResultPrint(ladderGame, "all");
    }
}
