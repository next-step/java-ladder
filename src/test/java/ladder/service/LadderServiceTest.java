package ladder.service;

import ladder.service.type.GameResult;
import ladder.domain.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderServiceTest {

    @Test
    public void getGameResult() {
        GameResult gameResult = LadderService.getLadderGameResult(PersonsTest.PERSONS_COUNT_2, LadderTest.LADDER_PERSON2);

        assertThat(gameResult.get(Person.getNameOf(PersonTest.PERSON_1)))
                .isEqualTo(ResultValue.valueOf(ResultValueTest.RESULT_VALUE_5000));
        assertThat(gameResult.get(Person.getNameOf(PersonTest.PERSON_2)))
                .isEqualTo(ResultValue.valueOf(ResultValueTest.RESULT_VALUE_FAIL));
    }
}
