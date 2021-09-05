package nextstep.ladders.domain;

import nextstep.ladders.exception.NotFoundDataException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ParticipantsTest {

    @Test
    @DisplayName("생성 테스트")
    void create() {
        final String participantText = "pobi,hounx,crong,jk";
        assertDoesNotThrow(() -> new Participants(participantText));
    }

    @Test
    @DisplayName("참가자를 찾을 수 없는 경우")
    void participantNotFound() {
        Participants participants = new Participants("pobi,hounx,crong,jk");
        Assertions.assertThrows(NotFoundDataException.class, () -> participants.indexOf(Participant.valueOf("abc")));
    }
}