package ladder.domain.participant;

import ladder.exception.InsufficientParticipantsCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {

    @ParameterizedTest
    @CsvSource(value = {"user1:user2:user3"}, delimiter = ':')
    public void createInstanceTest(String userName, String userName2, String userName3) {
        //Given & When
        Participants participants = Participants.of(Arrays.asList(userName, userName2, userName3));

        //Then
        assertThat(participants).isNotNull();
        assertThat(participants.getParticipantNames()).contains(userName, userName2, userName3);
    }

    @DisplayName("1명만 사다리 게임에 참가하였을 경우 예외처리 테스트")
    @Test
    public void insufficientParticipatePersons() {
        assertThatThrownBy(() ->
                Participants.of(Arrays.asList("user"))
        ).isInstanceOf(InsufficientParticipantsCountException.class);
    }


    @ParameterizedTest
    @CsvSource(value = {"user1:0", "user2:1", "user3:2"}, delimiter = ':')
    public void locateRowPointTest(String userName, int point) {
        //Given
        Participants participants = Participants.of(Arrays.asList("user1", "user2", "user3"));

        //When
        int expectedPoint = participants.findRowByParticipant(new Participant(userName, point));

        //Then
        assertThat(point).isEqualTo(expectedPoint);
    }
}
