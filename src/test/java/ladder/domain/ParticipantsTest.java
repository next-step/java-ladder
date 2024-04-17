package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    @Test
    @DisplayName("참가자 생성 테스트")
    public void initParticipantsTest() {
        Participants participants = new Participants(Arrays.asList("a", "b", "c"));

        assertThat(participants.getParticipantsCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("참가자 시작 위치 테스트")
    public void getParticipantStartLocationTest() {
        Participants participants = new Participants(Arrays.asList("a", "b", "c"));

        assertThat(participants.getParticipantStartLocation("a").getLocation()).isEqualTo(0);
        assertThat(participants.getParticipantStartLocation("b").getLocation()).isEqualTo(1);
        assertThat(participants.getParticipantStartLocation("c").getLocation()).isEqualTo(2);
    }

    @Test
    @DisplayName("참가자 존재 여부 테스트")
    public void isParticipantTest() {
        Participants participants = new Participants(Arrays.asList("a", "b", "c"));

        assertThat(participants.isParticipant("a")).isTrue();
        assertThat(participants.isParticipant("d")).isFalse();
    }
}
