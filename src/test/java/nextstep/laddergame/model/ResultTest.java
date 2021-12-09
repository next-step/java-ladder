package nextstep.laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @DisplayName("참가자와 사다리 결과를 생성자로 전달할 때 제대로 생성되었는지 검증")
    @Test
    void constructTest() {
        Participant participant = Participant.from("pobi");
        Goal goal = new Goal("꽝");
        Result result = new Result(participant, goal);

        assertThat(result.getParticipant()).isEqualTo(participant);
        assertThat(result.getGoal()).isEqualTo(goal);
    }
}
