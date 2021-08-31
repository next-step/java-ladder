package nextstep.ladders;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ParticipantsTest {

    @Test
    void 정상_생성() {
        final String participantText = "pobi,hounx,crong,jk";
        assertDoesNotThrow(() -> new Participants(participantText));
    }
}