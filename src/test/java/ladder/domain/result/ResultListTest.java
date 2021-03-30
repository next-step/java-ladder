package ladder.domain.result;

import ladder.Util;
import ladder.domain.participant.ParticipantList;
import ladder.exception.CustomException;
import ladder.exception.ErrorCode;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @ParameterizedTest
    @CsvSource(value = {
            "a,b,c,d,e:a,b,c,d,e:0,1,2,3,4:a,b,c,d,e",
            "a,b,c,d  :a,b,c,d  :3,2,1,0  :d,c,b,a"}, delimiter = ':')
    @DisplayName("결과목록을 섞어서 새로 생성할 수 있다")
    void canMixResultAccordingToIndices(String participantString, String resultString, String mixedIndicesString, String expectedString) {
        ParticipantList participantList = new ParticipantList(participantString);
        ResultList resultList = new ResultList(resultString, participantList);
        List<Integer> resultIndices = Util.parsedIntegerList(mixedIndicesString);
        ResultList mixedResultList = new ResultList(resultList, resultIndices);
        List<String> expectedList = Util.parsedStringList(expectedString);

        SoftAssertions softAssertions = new SoftAssertions();
        for (int index = 0; index < mixedResultList.size(); index++) {
            softAssertions.assertThat(mixedResultList.get(index).result()).isEqualTo(expectedList.get(index));
        }
        softAssertions.assertAll();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "a,b,c,d,e:a,a,a,a,a",
            "A,b,b,b:a,d,d,d",
            "a,a:b,e",
            "aa:1"}, delimiter = ':')
    @DisplayName("범위를 넘어가는 인덱스를 조회하면 INVALID_RESULT_INDEX를 던진다")
    void throwsExceptionOnInvalidIndexGet(String participantString, String resultString) {
        ParticipantList participantList = new ParticipantList(participantString);
        ResultList resultList = new ResultList(resultString, participantList);

        CustomException thrownOnNegative = assertThrows(CustomException.class, () -> resultList.get(-1));
        assertThat(thrownOnNegative.errorCode()).isEqualTo(ErrorCode.INVALID_RESULT_INDEX);

        CustomException thrownOnPositive = assertThrows(CustomException.class, () -> resultList.get(resultList.size()));
        assertThat(thrownOnPositive.errorCode()).isEqualTo(ErrorCode.INVALID_RESULT_INDEX);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "a,b,c,d,e:a,a,a,a,a",
            "A,b,b,b:a,d,d,d",
            "a,a:b,e",
            "aa:1"}, delimiter = ':')
    @DisplayName("범위를 넘어가는 인덱스를 조회하면 INVALID_RESULT_INDEX를 던진다")
    void throwsExceptionOnInvalidIndexGetName(String participantString, String resultString) {
        ParticipantList participantList = new ParticipantList(participantString);
        ResultList resultList = new ResultList(resultString, participantList);

        CustomException thrownOnNegative = assertThrows(CustomException.class, () -> resultList.getResult(-1));
        assertThat(thrownOnNegative.errorCode()).isEqualTo(ErrorCode.INVALID_RESULT_INDEX);

        CustomException thrownOnPositive = assertThrows(CustomException.class, () -> resultList.getResult(resultList.size()));
        assertThat(thrownOnPositive.errorCode()).isEqualTo(ErrorCode.INVALID_RESULT_INDEX);
    }

}
