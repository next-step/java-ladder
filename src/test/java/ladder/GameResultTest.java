package ladder;

import ladder.domain.GameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    private GameResult gameResult;

    @BeforeEach
    public void setupGameResult() {
        Map<String, String> gameResultMap = new HashMap<>();
        gameResultMap.put("test1", "꽝");
        gameResultMap.put("test2", "승리");
        gameResult = new GameResult(gameResultMap);
    }

    @DisplayName("GameResult 객체에서 Player 이름 문자열을 받으면 당첨 상품을 알려줌")
    @Test
    public void getGamePrizeByPlayerName() {
        assertThat(gameResult.getGamePrizeNameByPlayerName("test1")).isEqualTo("꽝");
        assertThat(gameResult.getGamePrizeNameByPlayerName("test2")).isEqualTo("승리");
    }

    @DisplayName("GameResult 객체에 저장되지 않은 Key 이름으로 접근시 예외 처리 String 문구 반환")
    @Test
    public void throwExceptionWhenInvalidKeyName() {
        assertThat(gameResult.getGamePrizeNameByPlayerName("null")).isEqualTo("해당 이름의 참가자는 존재하지 않습니다.");
    }
}
