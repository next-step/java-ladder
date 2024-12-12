package nextstep.ladder.domain.laddergame.position;

import nextstep.ladder.domain.ladder.LadderResult;
import nextstep.ladder.domain.laddergame.LadderGameResult2;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ResultPositionTest {

    @Test
    void create() {
        ResultPosition resultPosition = new ResultPosition();

        Assertions.assertThat(resultPosition).isNotNull();
    }

    @Test
    void create_map() {
        ResultPosition resultPosition = new ResultPosition(Map.of(0, 3));

        Assertions.assertThat(resultPosition).isNotNull();
    }

    @Test
    void getFinishPosition() {
        ResultPosition resultPosition = new ResultPosition(Map.of(0, 3));

        Assertions.assertThat(resultPosition.getFinishPosition(0)).isEqualTo(3);
    }

    @Test
    void match() {
        Map<Integer, Integer> positionMap = new HashMap<>();
        positionMap.put(0, 1);
        positionMap.put(1, 0);

        ResultPosition resultPosition = new ResultPosition(positionMap);

        Player player1 = new Player("test1");
        Player player2 = new Player("test2");
        Players players = new Players(List.of(player1, player2));

        LadderResult ladderResult = new LadderResult(List.of("꽝", "5000"));

        LadderGameResult2 gameResult = resultPosition.match(players, ladderResult);

        Assertions.assertThat(gameResult.getResult("test1")).isEqualTo("5000");
        Assertions.assertThat(gameResult.getResult("test2")).isEqualTo("꽝");
    }

}