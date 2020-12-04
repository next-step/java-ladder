package domain;

import dto.InputDto;
import org.junit.jupiter.api.Test;
import ui.ResultView;

public class LadderGameTest {

    @Test
    void printLadder() throws Exception {
        InputDto inputDto = new InputDto();

        inputDto.setNames("a,b,c,d,e");
        inputDto.setLadderHeight(5);
        inputDto.setResults("100,꽝,100,꽝,10000");

        LadderGame ladderGame = LadderGame.of(inputDto);
        
        ResultView.print(ladderGame);
    }
}
