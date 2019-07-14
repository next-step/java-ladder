package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantGoalsTest {

    @Test
    @DisplayName("참가자명 String으로 검색시 goal 객체 반환")
    void findGoal() {

        Participant participant = new Participant("test");
        Goal goal = new Goal("great");
        ParticipantGoals participantGoals = new ParticipantGoals(
                Arrays.asList(new ParticipantGoal(participant, goal)));

        ParticipantGoal participantGoal = participantGoals.find("test");
        assertThat(participantGoal.getParticipant()).isEqualTo(participant);
        assertThat(participantGoal.getGoal()).isEqualTo(goal);
    }

    @Test
    @DisplayName("참가자명 String으로 검색시 없다면 exception 발생")
    void findGoalException() {

        ParticipantGoals participantGoals = new ParticipantGoals(Collections.emptyList());

        assertThatIllegalArgumentException().isThrownBy(() -> participantGoals.find("notFound"));
    }
}