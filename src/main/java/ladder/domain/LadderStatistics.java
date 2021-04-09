package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LadderStatistics {
    private final static String ALL_PLAYERS = "all";
    private final static String MESSAGE_IMPROPER_PLAYER = "참여한 사람의 결과만 확인할 수 있습니다.";
    private final Map<Player, String> LadderResults;

    public LadderStatistics(Map ladderResults){
        LadderResults = ladderResults;
    }

    private void validate(Player player){
        if(!LadderResults.containsKey(player)){
            throw new IllegalArgumentException(MESSAGE_IMPROPER_PLAYER);
        }
    }

    public Map<Player, String> results(Player player){
        if(player.name().equalsIgnoreCase(ALL_PLAYERS)){
            return Collections.unmodifiableMap(LadderResults);
        }
        validate(player);
        Map<Player, String> result = new HashMap<>();
        result.put(player, LadderResults.get(player));
        return Collections.unmodifiableMap(result);
    }
}