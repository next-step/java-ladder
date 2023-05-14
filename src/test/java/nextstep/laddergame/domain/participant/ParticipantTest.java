package nextstep.laddergame.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantTest {
    @Test
    @DisplayName("참여자 이름이 없을 경우 exception")
    void emptyNameParticipant() {
        assertThatThrownBy(() -> new Participant(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여자 이름이 맞으면 true 틀리면 false")
    void indexByName() {
        final Participant participant1 = new Participant(new Name("1"));

        assertThat(participant1.isParticipant("1"))
                .isTrue();
        assertThat(participant1.isParticipant("2"))
                .isFalse();
    }
}
