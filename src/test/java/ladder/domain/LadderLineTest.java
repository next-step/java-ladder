package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLineTest {


    @Test
    @DisplayName("가로 사다리와 세로 사다리를 합쳐 사다리를 생성한다.")
    void should_return_ladder() {
        //Given
        String names = "pobi,crong,honux,jk";

        //When
        LadderLine ladderLine = new LadderLine(new Participants(names));

        //Then
        ladderLine.getValue().forEach(System.out::print);

    }

}
