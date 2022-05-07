package nextstep.step4.factory;

import nextstep.step4.domain.Ladder;
import nextstep.step4.domain.LadderResult;
import nextstep.step4.domain.PlayerName;
import nextstep.step4.domain.Players;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.*;

public class LadderGameResultsFactory {

    public static Map<PlayerName, String> create(Players players, Ladder ladder, LadderResult ladderResult) {
        Map<PlayerName, String> ladderGameResults = new HashMap<>();
        for (int playerColumn = 0; playerColumn < players.getCountOfPlayer(); playerColumn++) {
            ladderGameResults.put(
                    players.findPlayerByColumn(playerColumn),
                    ladderResult.findLadderResultByEndColumn(ladder.findEndColumByStartColumn(playerColumn))
            );
        }
        return unmodifiableMap(ladderGameResults);
    }

}
