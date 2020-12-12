package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    @Test
    @DisplayName("참가자들의 이름을 입력받아 사다리를 생성한다.")
    void should_return_ladder() {
        //Given
        String names = "pobi,crong,honux,jk";

        //When
        LadderLine ladderLine = new LadderLine(new Participants(names).size());

        //Then
        assertThat(ladderLine.getPoints().size()).isEqualTo(7);
    }

}
