package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultMatcherTest {

    @Test
    @DisplayName("PlayersOnLine과 Results매치하여 map생성")
    void match() {
        Players players = new Players(Arrays.asList(new Player("a"), new Player("b"), new Player("c")));
        PlayersOnLine playersOnLine = new PlayersOnLine(players);
        Results results = Results.from(3, "꽝,5000,3000");

        Matches match = ResultMatcher.match(playersOnLine, results);

        Map<Player, Result> playerResultMap = new HashMap<>();
        playerResultMap.put(new Player("a"), new Result("꽝"));
        playerResultMap.put(new Player("b"), new Result("5000"));
        playerResultMap.put(new Player("c"), new Result("3000"));
        Matches matchesExpected = new Matches(playerResultMap);
        assertThat(match).isEqualTo(matchesExpected);
    }
}