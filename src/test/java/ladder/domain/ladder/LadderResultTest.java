package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @Test
    @DisplayName("객체 생성")
    void construct() throws Exception {
        //given
        String namesOfPlayers = "god,pro,semi,ama";
        String namesOfAwards = "fail,5000,fail,3000";
        int ladderHeight = 5;

        Ladder ladder = Ladder.of(namesOfPlayers, ladderHeight);

        LadderResult ladderResult = LadderResult.of(ladder, namesOfAwards);

        //when

        //then
        assertThat(ladderResult).isEqualTo(LadderResult.of(ladder, namesOfAwards));

    }


}