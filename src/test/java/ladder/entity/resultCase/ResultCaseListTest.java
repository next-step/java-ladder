package ladder.entity.resultCase;

import ladder.Util;
import ladder.entity.participant.ParticipantList;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class ResultCaseListTest {

    @ParameterizedTest
    @ValueSource(strings = "a,b,c,d,e")
    void canGenerateResultCaseList(String input){
        ParticipantList participantList = new ParticipantList(input);
        List<ResultCase> testCase = Util.resultCaseList(input);
        ResultCaseList resultCaseList = new ResultCaseList(participantList, input);
        SoftAssertions softAssertions = new SoftAssertions();
        for(int index = 0;index<resultCaseList.size();index++){
            softAssertions.assertThat(resultCaseList.get(index)).isEqualTo(testCase.get(index));
        }
        softAssertions.assertAll();
    }

}
