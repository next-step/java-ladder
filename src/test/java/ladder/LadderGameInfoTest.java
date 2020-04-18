package ladder;

import ladder.domain.*;
import ladder.dto.LadderGameInfo;
import ladder.dto.LadderGameResults;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameInfoTest {
    @Test
    void match() {
        LadderGameInfo ladderGameInfo = new LadderGameInfo(Users.of("a,b,c"), LadderRewards.of("꽝,당첨,당첨2"));
        Map<Position, Position> results = new HashMap<>();
        results.put(new Position(0), new Position(2));
        results.put(new Position(1), new Position(0));
        results.put(new Position(2), new Position(1));
        LadderResults ladderResults = new LadderResults(results);

        Map<User, LadderReward> gameResults = new HashMap<>();
        gameResults.put(new User("a"), new LadderReward("당첨2"));
        gameResults.put(new User("b"), new LadderReward("꽝"));
        gameResults.put(new User("c"), new LadderReward("당첨"));
        assertThat(ladderGameInfo.match(ladderResults)).isEqualTo(new LadderGameResults(gameResults));
    }
}
