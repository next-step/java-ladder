package ladder.domain.engine;

import ladder.domain.nextstep.Player;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LadderResults {
    private final static String MESSAGE_IMPROPER_PLAYER = "참여한 사람의 결과만 확인할 수 있습니다.";
    private final Map<Player, String> LadderResults;

    public LadderResults(Map<Player, String> ladderResults){
        LadderResults = ladderResults;
    }

    private void validate(Player player){
        if(!LadderResults.containsKey(player)){
            throw new IllegalArgumentException(MESSAGE_IMPROPER_PLAYER);
        }
    }
    public Map<String, String> results(Player player){
        validate(player);
        Map<String, String> result = new HashMap<>();
        result.put(player.name(), LadderResults.get(player));
        return Collections.unmodifiableMap(result);
    }

    public Map<String, String> resultsOfAll(){
        Map<String, String> result = new HashMap<>();
        for(Player player : LadderResults.keySet()){
            result.put(player.name(), LadderResults.get(player));
        }
        return Collections.unmodifiableMap(result);
    }
}