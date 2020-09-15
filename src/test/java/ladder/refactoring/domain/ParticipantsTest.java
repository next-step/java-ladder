package ladder.refactoring.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {
    @Test
    void participants_creation_test() {
        String input = "pobi,honux,crong,jk";

        Participants participants = Participants.of(input);
        System.out.println(participants.toString());
    }

    @Test
    void participants_exception_test() {
        String empty = "";
        assertThatThrownBy(() -> Participants.of(empty))
                .isInstanceOf(NullPointerException.class);

        assertThatThrownBy(() -> Participants.of(null))
                .isInstanceOf(NullPointerException.class);

        String participant = " tdd";
        assertThatThrownBy(() ->Participants.of(participant))
                .isInstanceOf(IllegalArgumentException.class);

        String duplication = "pobi,pobi,tdd,clean";
        assertThatThrownBy(() -> Participants.of(duplication))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
