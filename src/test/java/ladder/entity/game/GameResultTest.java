package ladder.entity.game;

import ladder.Util;
import ladder.entity.participant.ParticipantList;
import ladder.entity.resultCase.ResultCase;
import ladder.entity.resultCase.ResultCaseList;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class GameResultTest {

    @ParameterizedTest
    @CsvSource(value = {
            "a,b,c,d,e :f,g,h,i,j",
            "A, b, C ,d:1,2,3,4,",
            "a,aa,aaa,aaaa,aaaaa:b,bb,bbb,bbbb,bbbbb"}, delimiter = ':')
    void shouldReturnDOES_NOT_EXIST_STATEMENTOnInvalidQuery(String inputString, String testString) {
        ParticipantList participantList = new ParticipantList(inputString);
        ResultCaseList resultList = new ResultCaseList(participantList, inputString);
        GameResult gameResult = new GameResult(participantList, resultList);

        List<String> testList = Util.stringList(testString);
        SoftAssertions softAssertions = new SoftAssertions();
        for (String test : testList) {
            softAssertions.assertThat(gameResult.result(test)).isEqualTo(new ResultCase(GameResult.DOES_NOT_EXIST_STATEMENT));
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
        ResultCaseList resultList = new ResultCaseList(participantList, inputString);
        GameResult gameResult = new GameResult(participantList, resultList);

        List<String> testList = Util.stringList(inputString);
        SoftAssertions softAssertions = new SoftAssertions();
        for (String test : testList) {
            softAssertions.assertThat(gameResult.result(test)).isEqualTo(new ResultCase(test));
        }
        softAssertions.assertAll();
    }
}
