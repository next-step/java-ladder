package nextstep.step2.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantsTest {

    @Test
    void 참여자가_존재하지_않으면_예외를_던진다() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Participants(new ArrayList<>())
        );
    }

    @Test
    void 참여자의_수를_반환한다() {
        final var participants = createParticipants();

        int actual = participants.count();

        assertThat(actual).isEqualTo(3);
    }

    @Test
    void 참여자의_위치를_반환한다() {
        final var participants = createParticipants();

        final var actual = participants.position("b");

        assertThat(actual).isEqualTo(1);
    }

    private Participants createParticipants() {
        final var participants = List.of(
                new Participant("a"), new Participant("b"), new Participant("c")
        );

        return new Participants(participants);
    }
}
