package ladder.domain.participant;

import ladder.exception.InValidUserNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantTest {

    @ParameterizedTest
    @CsvSource(value = {"hawn:0", "jin:1", "young:2"}, delimiter = ':')
    public void createInstanceTest(String userName, int startPosition) {
        //Given & When
        Participant participant = new Participant(userName, startPosition);

        //Then
        assertThat(participant).isEqualTo(new Participant(userName, startPosition));
    }

    @ParameterizedTest
    @CsvSource(value = {"user1:user1:user1", "user2:user2:user2", "user3:user3:user3"}, delimiter = ':')
    public void equalsTest(String userName1, String userName2, String userName3) {
        //Given & When
        Participant user1 = new Participant(userName1, 0);
        Participant user2 = new Participant(userName2, 0);
        Participant user3 = new Participant(userName3, 0);


        //Then
        assertThat(user1).isEqualTo(user2).isEqualTo(user3);
    }


    @ParameterizedTest
    @CsvSource(value = {"user1:user1:user1", "user2:user2:user2", "user3:user3:user3"}, delimiter = ':')
    public void hashcodeTest(String userName1, String userName2, String userName3) {
        //Given
        Map<Participant, Participant> participants = new HashMap<>();

        //When
        participants.put(new Participant(userName1, 0), new Participant(userName1, 0));
        participants.put(new Participant(userName2, 0), new Participant(userName2, 0));
        participants.put(new Participant(userName3, 0), new Participant(userName3, 0));

        //Then
        assertThat(participants.get(new Participant(userName1, 0)))
                .isEqualTo(new Participant(userName2, 0))
                .isEqualTo(new Participant(userName3, 0));

    }

    @DisplayName("이름에 Null 혹은 빈값으로 들어왔을 경우 예외처리 ")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"userNameName"})
    public void userNameValidationCheck(String userName) {
        assertThatThrownBy(() ->
                new Participant(userName, 0)
        ).isInstanceOf(InValidUserNameException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"user1:1:1", "user2:2:-1", "user3:3:0"}, delimiter = ':')
    public void movePosition(String userName, int startPosition, int direction) {
        //Given
        Participant participant = new Participant(userName, startPosition);
        Participant expectedParticipant = new Participant(userName, startPosition + direction);

        //When
        participant.movePosition(direction);
        expectedParticipant.movePosition(0);


        //Then
        assertThat(participant).isEqualTo(expectedParticipant);
    }

    @Test
    public void movePositionForEachTest() {
        //Given
        Participant participant = new Participant("name", 5);
        Participant expectedParticipant = new Participant("name", 10);

        //When
        for (int i = 0; i < 5; i++) {
            participant.movePosition(1);
            expectedParticipant.movePosition(0);
        }

        //Then
        assertThat(participant).isEqualTo(expectedParticipant);
    }
}
