package ladder.strategy;

import ladder.domain.result.ExecutionResults;
import ladder.domain.user.LadderPlayers;

import java.util.Map;

public interface PlayResult {

    Map<String, String> play(LadderPlayers players, ExecutionResults results);

}
