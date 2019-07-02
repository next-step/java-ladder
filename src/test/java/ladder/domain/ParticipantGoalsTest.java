package ladder.domain;

import org.assertj.core.util.Maps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantGoalsTest {

    @Test
    @DisplayName("참가자명 String으로 검색시 goal 객체 반환")
    void findGoal() {

        String participantName = "test";
        String goalResult = "great";

        ParticipantGoals participantGoals = new ParticipantGoals(
                Maps.newHashMap(new Participant(participantName), new Goal(goalResult))
        );

        assertThat(participantGoals.findGoal(participantName)).isEqualTo(new Goal(goalResult));
    }

    @Test
    @DisplayName("참가자명 String으로 검색시 없다면 exception 발생")
    void findGoalException() {

        ParticipantGoals participantGoals = new ParticipantGoals(Collections.emptyMap());

        assertThatIllegalArgumentException().isThrownBy(() -> participantGoals.findGoal("notFound"));
    }
}