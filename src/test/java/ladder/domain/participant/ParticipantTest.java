package ladder.domain.participant;

import ladder.exception.InValidUserNameException;
import org.junit.jupiter.api.DisplayName;
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
    @ValueSource(strings = {"hawn", "jin", "young"})
    public void createLadderStructure(String userName) {
        //Given & When
        Participant participant = new Participant(userName);

        //Then
        assertThat(participant).isEqualTo(new Participant(userName));
    }

    @ParameterizedTest
    @CsvSource(value = {"user1:user1:user1", "user2:user2:user2", "user3:user3:user3"}, delimiter = ':')
    public void equalsTest(String userName1, String userName2, String userName3) {
        //Given & When
        Participant user1 = new Participant(userName1);
        Participant user2 = new Participant(userName2);
        Participant user3 = new Participant(userName3);


        //Then
        assertThat(user1).isEqualTo(user2).isEqualTo(user3);
    }


    @ParameterizedTest
    @CsvSource(value = {"user1:user1:user1", "user2:user2:user2", "user3:user3:user3"}, delimiter = ':')
    public void hashcodeTest(String userName1, String userName2, String userName3) {
        //Given
        Map<Participant, Participant> participants = new HashMap<>();

        //When
        participants.put(new Participant(userName1), new Participant(userName1));
        participants.put(new Participant(userName2), new Participant(userName2));
        participants.put(new Participant(userName3), new Participant(userName3));

        //Then
        assertThat(participants.get(new Participant(userName1)))
                          .isEqualTo(new Participant(userName2))
                          .isEqualTo(new Participant(userName3));

    }

    @DisplayName("이름에 Null 혹은 빈값으로 들어왔을 경우 예외처리 ")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"userNameName"})
    public void userNameValidationCheck(String userName){
        assertThatThrownBy(() ->
                new Participant(userName)
        ).isInstanceOf(InValidUserNameException.class);
    }
}
