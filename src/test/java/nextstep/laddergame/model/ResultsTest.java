package nextstep.laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @DisplayName("참가자와 사다리 결과가 주어졌을 때 제대로 추가되었는지 검증")
    @Test
    void addAndGetTest() {
        Results results = new Results();
        Participant participant = Participant.from("pobi");
        Goal goal = new Goal("꽝");
        results.add(participant, goal);

        assertThat(results.get(participant)).isEqualTo(goal);
    }
}
