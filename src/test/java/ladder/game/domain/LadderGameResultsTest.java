package ladder.game.domain;

import ladder.player.domain.Player;
import ladder.prize.domain.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameResultsTest {

    private Map<Player, Prize> ladderGameResults;
    private Player player1;
    private Player player2;
    private Prize prize1;
    private Prize prize2;

    @BeforeEach
    void setUp() {
        player1 = Player.of("정원");
        prize1 = Prize.of("1등");
        player2 = Player.of("jwee0330");
        prize2 = Prize.of("꽝");

        this.ladderGameResults = new HashMap<>();
        ladderGameResults.put(player1, prize1);
        ladderGameResults.put(player2, prize2);
    }

    @DisplayName("모든 참여자, 결과가 매핑된 결과를 알 수 있다.")
    @Test
    public void getLadderGameResultsTest() {
        Map<Player, Prize> gameResults = new HashMap<>();
        gameResults.put(player1, prize2);
        gameResults.put(player2, prize1);

        LadderGameResults ladderGameResults = LadderGameResults.of(gameResults);
        Map<Player, Prize> allPlayersResult = ladderGameResults.getAllPlayersResult();

        assertThat(gameResults).isEqualTo(allPlayersResult);
    }

    @DisplayName("입력받은 참여자 한명의 결과를 알 수 있다.")
    @Test
    public void specificPlayersResult() {
        Map<Player, Prize> gameResults = new HashMap<>();
        gameResults.put(player1, prize2);
        gameResults.put(player2, prize1);

        LadderGameResults ladderGameResults = LadderGameResults.of(gameResults);
        Map<Player, Prize> specificPlayerResult = ladderGameResults.getSpecificPlayerResult(player1.getName());

        assertThat(specificPlayerResult.keySet()).containsExactly(player1);
        assertThat(specificPlayerResult.values()).containsExactly(prize2);
    }

}
