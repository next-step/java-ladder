package ladder.domain;

import ladder.view.LadderGameView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LaddersTest {

    @Test
    @DisplayName("사람 이름, 사다리 높이를 입력 받아 사다리 생성")
    void should_return_ladders() {

        //Given
        String names = "pobi,honux,crong,jk";
        int ladderHeight = 10;

        //When
        Ladders ladders = new Ladders(new Participants(names), new LadderHeight(ladderHeight));

        //Then
        LadderGameView.printLadders(ladders);

    }


}