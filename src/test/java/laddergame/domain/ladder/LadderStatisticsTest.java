package laddergame.domain.ladder;

import laddergame.domain.player.Player;
import laddergame.domain.player.Players;
import laddergame.domain.player.PlayersTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderStatisticsTest {
    private LadderStatistics statistics;
    private Ladder ladder;
    private Players players;
    private Results results;
    private List<Result> resultList;
    private List<Integer> moveIndexList;
    private int height = 5;
    private int numbers = 4;
    private int index = 2;

    @BeforeEach
    void setUp() {
        ladder = LadderTest.makeTestLadder(new Size(height, numbers));
        moveIndexList = Arrays.asList(2, 3, 0, 1);
        players = PlayersTest.makeTestPlayers(numbers);
        resultList = Arrays.asList(new Result("꽝"), new Result("1000"), new Result("2000"), new Result("3000"));
        results = new Results(resultList);
        statistics = new LadderStatistics(ladder, results);
    }

    @Test
    @DisplayName("한 명의 플레이어의 결과값을 반환한다.")
    void 결과하나매치() {
        Map<Player, Result> predict = new HashMap<>();
        int index = 0;
        Player player = players.getPlayers().get(index);
        predict.put(player, results.getOne(moveIndexList.get(index)));

        assertThat(statistics.matchOne(players, index)).isEqualTo(predict);
    }

    @Test
    @DisplayName("모든 플레이어의 결과값을 반환한다.")
    void 모든결과매치 () {
        Map<Player, Result> predict = new HashMap<>();
        List<Player> playerList = players.getPlayers();
        IntStream.range(0, playerList.size())
                .forEach(i -> predict.put(playerList.get(i), results.getOne(moveIndexList.get(i))));

        assertThat(statistics.matchAll(players)).isEqualTo(predict);
    }
}
