package ladder.service;

import ladder.controller.response.ResultDto;
import ladder.service.type.GameResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderServiceTest {
    private static final String GET_ALL_COMMENT = "all";
    private GameResult gameResult;

    public LadderServiceTest() {
        gameResult = GameResult.getInstance();
        String person1 = "a";
        String person2 = "b";
        String person3 = "c";
        String result1 = "꽝";
        String result2 = "100";
        String result3 = "1000";

        gameResult.put(person1, result1);
        gameResult.put(person2, result2);
        gameResult.put(person3, result3);
    }

    @Test
    public void getAllResult() {
        ResultDto resultDto = LadderService.getRequestedResult(gameResult, GET_ALL_COMMENT);

        assertThat(resultDto.getNames())
                .isEqualTo(gameResult.getGameResult().keySet());
    }

    @Test
    public void getOneResult() {
        String person = "a";
        ResultDto resultDto = LadderService.getRequestedResult(gameResult, person);

        assertThat(resultDto.getResultValue(person)).isEqualTo(gameResult.get(person));
    }
}
