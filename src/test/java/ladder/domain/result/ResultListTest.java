package ladder.domain.result;

import ladder.domain.participant.Participant;
import ladder.domain.participant.ParticipantList;
import ladder.exception.CustomException;
import ladder.exception.ErrorCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultListTest {

    @ParameterizedTest
    @CsvSource(value = {
            "a,b,c,d,e:a,a,a,a,a:5",
            "A,b,b,b:a,d,d,d:4",
            "a,a:b,e:2",
            "aa:1:1"}, delimiter = ':')
    @DisplayName("결과목록을 생성할 수 있다")
    void canGenerateResultList(String participantString, String resultString, int expected) {
        ParticipantList participantList = new ParticipantList(participantString);
        ResultList resultList = new ResultList(resultString, participantList);
        assertThat(resultList.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "a,b,c,d,e:a,a,a,a",
            "A,b,b,b:a,d,d",
            "a,a:b,e,a",
            "aa:1,d"}, delimiter = ':')
    @DisplayName("결과목록의 수와 참가자의 수가 다르면 INVALID_RESULT_SIZE을 던진다")
    void invalidResultSizeThrowsException(String participantString, String resultString) {
        ParticipantList participantList = new ParticipantList(participantString);
        CustomException thrown = assertThrows(CustomException.class, () -> new ResultList(resultString, participantList));
        assertThat(thrown.errorCode()).isEqualTo(ErrorCode.INVALID_RESULT_SIZE);
    }

}
