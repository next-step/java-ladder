package ladder.view;

import ladder.domain.LadderGame;
import org.junit.jupiter.api.Test;

public class OutputVIewTest {
    @Test
    void resultPrint() {
        LadderGame ladderGame = new LadderGame("pobi,honux,crong,jk", "5");
        OutputView.resultPrint(ladderGame);
    }
}
