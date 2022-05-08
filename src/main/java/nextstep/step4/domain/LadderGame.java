package nextstep.step4.domain;

import nextstep.step4.factory.LadderGameResultsFactory;

import java.util.Map;
import java.util.Map.Entry;

import static java.util.stream.Collectors.*;

public class LadderGame {

    private final Map<PlayerName, String> ladderGameResults;

    private LadderGame(Players players, Ladder ladder, LadderResult ladderResult) {
        ladderGameResults = LadderGameResultsFactory.create(players, ladder, ladderResult);
    }

    public static LadderGame of(Players players, Ladder ladder, LadderResult ladderResult) {
        return new LadderGame(players, ladder, ladderResult);
    }

    public Map<PlayerName, String> findResultsByPlayerName(String playerName) {
        if (isAll(playerName)) {
            return ladderGameResults;
        }

        return findOneResult(playerName);
    }

    private boolean isAll(String playerName) {
        return playerName.equals("all");
    }

    private Map<PlayerName, String> findOneResult(String playerName) {
        return ladderGameResults.entrySet()
                .stream()
                .filter(result -> result.getKey().equals(PlayerName.from(playerName)))
                .collect(toMap(Entry::getKey, Entry::getValue));
    }
}
