package nextstep.ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GameResults {

    private static final String INVALID_PLAYER_AND_RESULT_SIZE = "플레이어의 수와 사다리 결과들의 수가 일치하지 않습니다.";

    private final Map<Player, LadderResult> results;

    public GameResults(Map<Player, LadderResult> results) {
        this.results = Collections.unmodifiableMap(results);
    }

    public static GameResults of(List<Player> players, List<LadderResult> ladderResults, Ladder ladder) {
        validate(players, ladderResults);
        Map<Player, LadderResult> results = new LinkedHashMap<>();
        for(int startIndex=0; startIndex<players.size(); startIndex++){
            int endIndex = ladder.findResult(startIndex);
            results.put(players.get(startIndex), ladderResults.get(endIndex));
        }
        return new GameResults(results);
    }

    private static void validate(List<Player> players, List<LadderResult> results) {
        if(players.size() != results.size()){
            System.out.println(INVALID_PLAYER_AND_RESULT_SIZE);
        }
    }

    public LadderResult getResultByName(String name) {
        return results.get(Player.of(name));
    }

    public Map<Player, LadderResult> getResults() {
        return results;
    }
}
