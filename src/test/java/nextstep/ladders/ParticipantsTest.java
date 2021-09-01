package nextstep.ladders;

import nextstep.ladders.exception.NotFoundDataException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ParticipantsTest {

    @Test
    void 정상_생성() {
        final String participantText = "pobi,hounx,crong,jk";
        assertDoesNotThrow(() -> new Participants(participantText));
    }

    @Test
    void 참가자를_찾을_수_없는_경우() {
        Participants participants = new Participants("pobi,hounx,crong,jk");
        Assertions.assertThrows(NotFoundDataException.class, () -> participants.indexOf(Participant.valueOf("abc")));
    }
}