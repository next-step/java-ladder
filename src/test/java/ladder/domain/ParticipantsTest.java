package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    public static final Participants PARTICIPANTS = new Participants(Arrays.asList(ParticipantTest.PARTICIPANT_A, ParticipantTest.PARTICIPANT_B, ParticipantTest.PARTICIPANT_C));

    @Test
    @DisplayName("참가자 생성 테스트")
    public void initParticipantsTest() {
        Participants participants = new Participants(Arrays.asList(ParticipantTest.PARTICIPANT_A, ParticipantTest.PARTICIPANT_B, ParticipantTest.PARTICIPANT_C));

        assertThat(participants.getParticipantsCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("참가자 존재 여부 테스트")
    public void isParticipantTest() {
        assertThat(PARTICIPANTS.isParticipant("a")).isTrue();
        assertThat(PARTICIPANTS.isParticipant("d")).isFalse();
    }
}
