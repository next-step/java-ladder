package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantTest {
    public static final Participant PARTICIPANT_A = new Participant("a", 0);
    public static final Participant PARTICIPANT_B = new Participant("b", 1);
    public static final Participant PARTICIPANT_C = new Participant("c", 2);

    @Test
    @DisplayName("참가자 위치 이동 테스트")
    void updateLocationTest() {
        PARTICIPANT_A.updateLocation(DirectionTest.RIGHT);
        assertThat(PARTICIPANT_A.getLocation()).isEqualTo(1);
        PARTICIPANT_B.updateLocation(DirectionTest.LEFT);
        assertThat(PARTICIPANT_B.getLocation()).isEqualTo(0);
    }

}