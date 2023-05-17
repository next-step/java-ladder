package nextstep.step2.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
    void 참여자를_출력형식에_맞게_변환한다() {
        final var name = "pobi,honux,crong,jk";
        final var participants = new Participants(name);

        final var actual = participants.toParticipants();

        assertThat(actual).isEqualTo("pobi honux crong jk");
    }
}
