package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {


    @Test
    @DisplayName("가로 사다리와 세로 사다리를 합쳐 사다리를 생성한다.")
    void should_return_ladder() {
        //Given
        int personCount = 10;

        //When
        Ladder ladder = new Ladder(personCount);

        //Then
        ladder.getValue().forEach(System.out::print);

    }

}