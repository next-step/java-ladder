package nextstep.step2.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantsTest {

    @Test
    void 참여자가_존재하지_않으면_예외를_던진다() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Participants(new ArrayList<>())
        );
    }
}
