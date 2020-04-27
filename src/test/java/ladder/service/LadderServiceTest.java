package ladder.service;

import ladder.controller.response.GameResultDto;
import ladder.domain.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderServiceTest {

    @Test
    public void getGameResult() {
        GameResultDto gameResultDto = LadderService.getLadderGameResult(PersonsTest.PERSONS_COUNT_2, LadderTest.LADDER_PERSON2);

        assertThat(gameResultDto.get(PersonTest.PERSON_1)).isEqualTo(ResultValueTest.RESULT_VALUE_5000);
        assertThat(gameResultDto.get(PersonTest.PERSON_2)).isEqualTo(ResultValueTest.RESULT_VALUE_FAIL);
    }
}
