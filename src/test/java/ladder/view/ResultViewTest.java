package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultViewTest {

    @Test
    @DisplayName("출력 테스트")
    void printResult() {

        Participants participants = new Participants("pobi,honux,crong,jk");
        Ladder ladder = new Ladder(participants.size(), 5);

        ResultView.printResult(participants, ladder);
    }
}