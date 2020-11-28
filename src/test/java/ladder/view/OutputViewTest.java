package ladder.view;

import ladder.domain.LadderGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    @DisplayName("출력 테스트용")
    @Test
    void printUserNameTest() {
        // given
        final LadderGame ladderGame = LadderGame.of("pobi,honux,crong,jk,sung,min,hong", 8);
        
        OutputView.printLadderViewResult(ladderGame.getLadderViewResult());
    }

}