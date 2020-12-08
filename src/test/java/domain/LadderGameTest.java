package domain;

import dto.InputDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.ResultView;

public class LadderGameTest {

    @Test
    @DisplayName("사람 이름과 결과, 사다리 높이를 입력받은 후 해당 사다리를 출력하는 테스트")
    void printLadder() {
        InputDto inputDto = new InputDto();

        inputDto.setNames("a,b,c,d,e");
        inputDto.setLadderHeight(5);
        inputDto.setResults("100,꽝,100,꽝,10000");

        LadderGame ladderGame = LadderGame.of(inputDto);
        
        ResultView.print(ladderGame);
    }
}
