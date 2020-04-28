package ladder.service;

import ladder.controller.response.ResultDto;
import ladder.service.type.GameResult;
import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderServiceTest {

    @Test
    @DisplayName("주어진 사람 이름의 사다리타기의 결과값 정상 반환 확인")
    public void getRequestResults() {
        GameResult gameResult = LadderService.getLadderGameResult(PersonsTest.PERSONS_COUNT_2, LadderTest.LADDER_PERSON2);

        ResultDto resultDto = LadderService.getRequestedResult(gameResult, new String[]{Person.getNameOf(PersonTest.PERSON_1)});

        assertThat(resultDto.getNames()).contains(Person.getNameOf(PersonTest.PERSON_1));
    }

    @Test
    @DisplayName("사다리타기의 결과값 정상 반환 확인")
    public void getLadderGameResult() {
        GameResult gameResult = LadderService.getLadderGameResult(PersonsTest.PERSONS_COUNT_2, LadderTest.LADDER_PERSON2);

        assertThat(gameResult.get(Person.getNameOf(PersonTest.PERSON_1)))
                .isEqualTo(ResultValue.valueOf(ResultValueTest.RESULT_VALUE_5000));
        assertThat(gameResult.get(Person.getNameOf(PersonTest.PERSON_2)))
                .isEqualTo(ResultValue.valueOf(ResultValueTest.RESULT_VALUE_FAIL));
    }
}
