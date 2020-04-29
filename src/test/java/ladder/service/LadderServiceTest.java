package ladder.service;

import ladder.controller.response.ResultDto;
import ladder.service.type.GameResult;
import ladder.domain.*;
import ladder.view.exception.InvalidInputToGetResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderServiceTest {

    @Test
    @DisplayName("전체 사다리타기 결과값 정상 반환 확인")
    public void getAllResult() {
        GameResult gameResult = LadderService.getLadderGameResult(PersonsTest.PERSONS_COUNT_2, LadderTest.LADDER_PERSON2);

        ResultDto resultDto = LadderService.getAllResult(gameResult);

        assertThat(resultDto.getNames()).contains(Person.getNameOf(PersonTest.PERSON_1));
        assertThat(resultDto.getNames()).contains(Person.getNameOf(PersonTest.PERSON_2));
    }

    @Test
    @DisplayName("주어진 사람 이름의 사다리타기의 결과값 정상 반환 확인")
    public void getRequestResult() {
        GameResult gameResult = LadderService.getLadderGameResult(PersonsTest.PERSONS_COUNT_2, LadderTest.LADDER_PERSON2);

        ResultDto resultDto = LadderService.getRequestedResult(gameResult, Person.getNameOf(PersonTest.PERSON_1));

        assertThat(resultDto.getNames()).contains(Person.getNameOf(PersonTest.PERSON_1));
    }

    @Test
    @DisplayName("주어진 사람 이름이 존재하지 않을 경우 예외처리 확인")
    public void throwExceptionRequestResultNotExist() {
        GameResult gameResult = LadderService.getLadderGameResult(PersonsTest.PERSONS_COUNT_2, LadderTest.LADDER_PERSON2);

        assertThatExceptionOfType(InvalidInputToGetResult.class).isThrownBy(
                () -> LadderService.getRequestedResult(gameResult, Person.getNameOf(PersonTest.PERSON_3))
        );
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
