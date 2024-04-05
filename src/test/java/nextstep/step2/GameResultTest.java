package nextstep.step2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameResultTest {

    @Test
    void gameResult_값이_정상적으로_생성된다() {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("pobi", "꽝");
        resultMap.put("honux", "3000");
        GameResult gameResult = new GameResult(resultMap);
        assertEquals("꽝", gameResult.getResult("pobi"));
        assertEquals("3000", gameResult.getResult("honux"));
    }
}
