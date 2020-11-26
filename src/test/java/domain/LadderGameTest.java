package domain;

import org.junit.jupiter.api.Test;
import ui.ResultView;

public class LadderGameTest {

    @Test
    void printLadder() {
        LadderGame ladderGame = LadderGame.of("a,b,c,d,e",10);
        ResultView.print(ladderGame);
    }
}
