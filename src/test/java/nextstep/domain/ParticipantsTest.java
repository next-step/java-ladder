package nextstep.domain;

import nextstep.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("참여자")
public class ParticipantsTest {

    @DisplayName("참여자의 트랙번호 구하기")
    @ParameterizedTest
    @CsvSource(value = { "a,0", "b,1", "c,2", "d,3", "e,4" })
    public void test(String personName, int result) {
        Participants participants = new Participants(PersonFactory.createPersons("a,b,c,d,e"));
        assertThat(participants.getTrackNumberByPersonName(personName)).isEqualTo(result);
    }

}
