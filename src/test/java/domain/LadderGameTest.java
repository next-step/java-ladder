package domain;

import org.junit.jupiter.api.Test;
import ui.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    void printLadder() {
        LadderGame ladderGame = LadderGame.of("a,b,c,d,e",10);
        ResultView.print(ladderGame);
    }
}
