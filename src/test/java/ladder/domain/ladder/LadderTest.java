package ladder.domain.ladder;

import ladder.domain.user.Participants;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void 사다리_게임_결과_생성() {
        // given
        int ladderHeight = 3;
        int numberOfParticipant = 4;
        LadderGenerator ladderGenerator = new LadderGenerator(() -> true);
        Ladder ladder = ladderGenerator.generate(ladderHeight, numberOfParticipant);

        Participants participants = new Participants("dugi,manse,pobi,tomas");

        // when
        LadderResult ladderResult = ladder.play(new InputLadderResult("5000,1000,꽝,꿀밤"), participants);

        // then
        HashMap<String, String> expectedResults = new HashMap<>();
        expectedResults.put("dugi", "1000");
        expectedResults.put("manse", "5000");
        expectedResults.put("pobi", "꿀밤");
        expectedResults.put("tomas", "꽝");
        assertThat(ladderResult.getResults("all")).isEqualTo(expectedResults);
    }
}