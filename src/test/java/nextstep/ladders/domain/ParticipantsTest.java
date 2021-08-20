package nextstep.ladders.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParticipantsTest {

    @Test
    void 정상_생성() {
        final String participantText = "pobi,hounx,crong,jk";
        assertDoesNotThrow(() -> {
            Participants participants = new Participants(participantText);
            assertEquals(participants.count(), participants.count());
        });
    }
}