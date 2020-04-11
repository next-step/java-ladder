package ladder.domain.result;

import ladder.model.player.PlayerName;
import ladder.model.prize.PrizeName;
import ladder.model.result.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @DisplayName("플레이어 이름을 인자로 주면, 실행 결과를 알려준다.")
    @ParameterizedTest
    @CsvSource(value = {"Yuqi:5000", "Sujin:1000", "Shuha:꽝"}, delimiter = ':')
    void findResultByPlayerName(String playerName, String prizeName) {
        //given
        GameResult gameResult = new GameResult(createMapForTest());

        //when
        GameResult resultToKnow = gameResult.findResultByPlayerName(playerName);

        //then
        assertThat(resultToKnow.findResultByPlayerName(playerName).getKeySet())
                .contains(PlayerName.of(playerName))
                .hasSize(1);
    }

    @DisplayName("플레이어 이름을 인자로 주면, 실행 결과를 알려준다.")
    @ParameterizedTest
    @CsvSource(value = {"Yuqi:5000", "Sujin:1000", "Shuha:꽝"}, delimiter = ':')
    void findPrizeNameByPlayerName(String playerName, String prizeName) {
        //given
        GameResult gameResult = new GameResult(createMapForTest());

        //when
        String prizeByPlayerName = gameResult.findPrizeByPlayerName(playerName);

        //then
        assertThat(prizeByPlayerName).isEqualTo(prizeName);
    }

    @DisplayName("알고 싶은 실행 결과로 all 을 입력하면 모두의 성적을 보여준다.")
    @Test
    void returnAllResult() {
        //given
        GameResult gameResult = new GameResult(createMapForTest());
        String playerNameToKnow = "all";

        //when
        GameResult resultByPlayerName = gameResult.findResultByPlayerName(playerNameToKnow);

        //then
        assertThat(resultByPlayerName.getKeySet().size()).isEqualTo(3);
    }

    private Map<PlayerName, PrizeName> createMapForTest() {
        Map<PlayerName, PrizeName> result = new HashMap<>();
        result.put(PlayerName.of("Yuqi"), PrizeName.of("5000"));
        result.put(PlayerName.of("Sujin"), PrizeName.of("1000"));
        result.put(PlayerName.of("Shuha"), PrizeName.of("꽝"));
        return result;
    }
}