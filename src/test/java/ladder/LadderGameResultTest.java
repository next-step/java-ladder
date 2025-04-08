package ladder;

import ladder.domain.LadderGameResult;
import ladder.domain.Player;
import ladder.domain.Prize;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameResultTest {

    @Test
    public void 참가자의_이름을_입력하면_결과를_반환한다() {
        Player player1 = new Player("참가자1");
        Player player2 = new Player("참가자2");
        Player player3 = new Player("참가자3");

        Prize prize1 = new Prize("꽝");
        Prize prize2 = new Prize("5000");
        Prize prize3 = new Prize("3000");

        Map<Player, Prize> gameResultMap = new HashMap<>();
        gameResultMap.put(player1, prize1);
        gameResultMap.put(player2, prize2);
        gameResultMap.put(player3, prize3);

        LadderGameResult ladderGameResult = new LadderGameResult(gameResultMap);
        assertThat(ladderGameResult.findPrizeByPlayerName("참가자1")).isEqualTo(prize1);
        assertThat(ladderGameResult.findPrizeByPlayerName("참가자2")).isEqualTo(prize2);
        assertThat(ladderGameResult.findPrizeByPlayerName("참가자3")).isEqualTo(prize3);
    }

}
