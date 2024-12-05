package ladder.domain.engine;

import ladder.domain.nextstep.Players;

import java.util.List;
import java.util.Map;

public interface LadderResults {

    void processLadderGameOutcomes(Players players, Ladder ladder);

    Map<String, String> ladderGameOutcomes();

    List<String> executionResults();

}
