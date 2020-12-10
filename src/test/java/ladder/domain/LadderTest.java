package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사람 이름, 사다리 높이를 입력 받아 사다리 생성")
    void should_return_ladders() {

        //Given
        Participants participants = new Participants("pobi,honux,crong,jk");
        int ladderHeight = 10;

        //When
        Ladder ladder = new Ladder(participants, new LadderHeight(ladderHeight));

        //Then
        assertThat(ladder.getLadderLines().size()).isEqualTo(ladderHeight);
        assertThat(ladder.getLadderLines().get(0).getValue().size()).isEqualTo(7);

    }


}
