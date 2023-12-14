package nextstep.ladder.domain;

import nextstep.ladder.exception.CannotRegisterNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParticipantTest {
    @Test
    @DisplayName("참가자의 이름이 5글자를 초과하는 경우 Exception Throw")
    void participantName_5글자초과_Test() {
        String name = "hvoiunq";
        assertThrows(CannotRegisterNameException.class, () -> Participant.nameOf(name));
    }
    @Test
    @DisplayName("참가자의 이름이 1글자 미만인 경우 Exception Throw")
    void participantName_1글자미만_Test() {
        String name = " ";
        assertThrows(CannotRegisterNameException.class, () -> Participant.nameOf(name));
    }
    @Test
    @DisplayName("참가자의 이름이 1글자~5글자인 경우 정상")
    void participantNameTest() {
        String name = "hvo";
        assertDoesNotThrow(() -> Participant.nameOf(name));
    }
}
