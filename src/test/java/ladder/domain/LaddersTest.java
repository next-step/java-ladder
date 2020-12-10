package ladder.domain;

import ladder.view.LadderGameView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LaddersTest {

    @Test
    @DisplayName("사람 이름, 사다리 높이를 입력 받아 사다리 생성")
    void should_return_ladders() {

        //Given
        Participants participants = new Participants("pobi,honux,crong,jk");
        int ladderHeight = 10;

        //When
        Ladders ladders = new Ladders(participants, new LadderHeight(ladderHeight));

        //Then
        LadderGameView.printLadders(ladders, participants.getValue());

    }


}