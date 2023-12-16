package nextstep.ladder.domain;

import nextstep.ladder.exception.CannotRegisterNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParticipantTest {
    @Test
    @DisplayName("참가자의 이름이 5글자를 초과하는 경우 Exception 밝생")
    void participantName_5글자초과_Test() {
        String name = "hvoiunq";
        assertThrows(CannotRegisterNameException.class, () -> Participant.nameOf(name, 0));
    }
    @Test
    @DisplayName("참가자의 이름이 1글자 미만인 경우 Exception 발생")
    void participantName_1글자미만_Test() {
        String name = " ";
        assertThrows(CannotRegisterNameException.class, () -> Participant.nameOf(name, 0));
    }
    @Test
    @DisplayName("참가자의 이름이 1글자~5글자인 경우 정상")
    void participantNameTest() {
        String name = "hvo";
        assertDoesNotThrow(() -> Participant.nameOf(name, 0));
    }

    @Test
    @DisplayName("참가자는 현재 위치를 가질 수 있다.")
    void ParticipantPositionTest() {
        Participant participant = Participant.nameOf("test", 1);
        assertThat(participant.getPosition()).isEqualTo(1);
    }
}
