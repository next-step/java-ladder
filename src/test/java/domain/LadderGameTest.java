package domain;

import org.junit.jupiter.api.Test;
import ui.ResultView;

public class LadderGameTest {

    @Test
    void printLadder() throws Exception {
        PlayerNames playerNames = PlayerNames.of("a,b,c,d,e");
        Length height = Length.of(10);
        //LadderGame ladderGame = LadderGame.of(playerNames,height);
        
        //ResultView.print(ladderGame);
    }
}
