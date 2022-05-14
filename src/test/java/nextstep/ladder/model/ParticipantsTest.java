package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {
    @Test
    @DisplayName("사다리 게임할 참가자의 수와 참가자 명단의 숫자가 일치하는지 확인합니다.")
    void join() {
        String[] names = {"a", "b", "c"};
        Participants participants = new Participants(names);
        assertThat(names).hasSize(participants.size());
    }
}