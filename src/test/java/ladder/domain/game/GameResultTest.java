package ladder.domain.game;

import ladder.Util;
import ladder.domain.participant.ParticipantList;
import ladder.domain.result.ResultList;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @ParameterizedTest
    @CsvSource(value = {
            "a:false",
            "A:false",
            "@all:true"}, delimiter = ':')
    @DisplayName("@all을 멈춤조건으로 판단한다")
    void shouldStopReturnsTrueOnValidInput(String inputString, boolean expected) {
        assertThat(GameResult.shouldStop(inputString)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "a,b,c,d,e :f,g,h,i,j",
            "A, b, C ,d:1,2,3,4,",
            "a,aa,aaa,aaaa,aaaaa:b,bb,bbb,bbbb,bbbbb"}, delimiter = ':')
    @DisplayName("존재하지 않는 값을 쿼리하면 DOES_NOT_EXIST_STATEMENT에 해당하는 결과를 리턴한다")
    void shouldReturnDOES_NOT_EXIST_STATEMENTOnInvalidQuery(String inputString, String testString) {
        ParticipantList participantList = new ParticipantList(inputString);
        ResultList resultList = new ResultList(inputString, participantList);
        GameResult gameResult = new GameResult(participantList, resultList);

        List<String> testList = Util.parsedStringList(testString);
        SoftAssertions softAssertions = new SoftAssertions();
        for (String test : testList) {
            softAssertions.assertThat(gameResult.result(test)).isEqualTo(GameResult.DOES_NOT_EXIST_STATEMENT);
        }
        softAssertions.assertAll();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "a,b,c,d,e",
            "A, b, C ,d",
            "a,aa,aaa,aaaa,aaaaa"})
    @DisplayName("존재하는 값을 쿼리하면 해당하는 결과를 리턴한다")
    void shouldReturnValidQueryResult(String inputString) {
        ParticipantList participantList = new ParticipantList(inputString);
        ResultList resultList = new ResultList(inputString, participantList);
        GameResult gameResult = new GameResult(participantList, resultList);

        List<String> testList = Util.parsedStringList(inputString);
        SoftAssertions softAssertions = new SoftAssertions();
        for (String test : testList) {
            softAssertions.assertThat(gameResult.result(test)).isEqualTo(test);
        }
        softAssertions.assertAll();
    }

}
