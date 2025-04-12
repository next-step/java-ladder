package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {
    @Test
    void 참가자_생성_테스트() {
        Participants participants = new Participants(List.of(
                new Participant("aa"),
                new Participant("bb")
        ));

        assertThat(participants.getParticipantsCount()).isEqualTo(2);
        assertThat(participants.getNames()).containsAll(List.of(new Participant("aa"), new Participant("bb")));
    }
}