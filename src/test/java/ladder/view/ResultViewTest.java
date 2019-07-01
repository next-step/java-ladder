package ladder.view;

import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultViewTest {

    @Test
    @DisplayName("출력 테스트")
    void printResult() {

        Participants participants = new Participants("pobi,honux,crong,jk");
        Ladder ladder = new Ladder(participants.size(), 5);
        LadderResults ladderResults = new LadderResults("꽝,5000,꽝,3000", participants.size());

        ResultView.print(participants, ladder, ladderResults);
    }
}