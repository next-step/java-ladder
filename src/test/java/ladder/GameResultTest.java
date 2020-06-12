package ladder;

import ladder.domain.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @DisplayName("GameResult 객체에서 Player 이름 문자열을 받으면 당첨 상품을 알려줌")
    @Test
    public void getGamePrizeByPlayerName() {
        Map<String, String> gameResultMap = new HashMap<>();
        gameResultMap.put("test1", "꽝");
        gameResultMap.put("test2", "승리");

        GameResult gameResult = new GameResult(gameResultMap);

        assertThat(gameResult.getGamePrizeNameByPlayerName("test1")).isEqualTo("꽝");
        assertThat(gameResult.getGamePrizeNameByPlayerName("test2")).isEqualTo("승리");
    }
}
