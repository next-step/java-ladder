package ladder.domain.result;

import ladder.model.player.PlayerName;
import ladder.model.prize.PrizeName;
import ladder.model.result.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @DisplayName("플레이어 이름을 인자로 주면, 실행 결과를 알려준다.")
    @ParameterizedTest
    @CsvSource(value = {"Yuqi:5000", "Sujin:1000", "Shuha:꽝"}, delimiter = ':')
    void findPrizeNameByPlayerName(String playerName, String prizeName) {
        //given
        Map<PlayerName, PrizeName> result = new HashMap<>();
        result.put(PlayerName.of("Yuqi"), PrizeName.of("5000"));
        result.put(PlayerName.of("Sujin"), PrizeName.of("1000"));
        result.put(PlayerName.of("Shuha"), PrizeName.of("꽝"));
        GameResult gameResult = new GameResult(result);

        //when
        String prize = gameResult.findPrizeByPlayerName(playerName);

        //then
        assertThat(prize).isEqualTo(prizeName);
    }
}