package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {

    @Test
    void 참가자를_생성한다() {
        //given
        Participant participant = Participant.of("java");
        //when
        //then
        assertThat(participant).isEqualTo(Participant.of("java"));
    }
}
