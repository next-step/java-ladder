package ladder.step2.domain;

import java.util.HashMap;

public class LadderGameResults {
    private static final String NOT_EXIST_PLAYER_NAME_EXCEPTION_MESSAGE = "존재하지 않는 플레이어입니다. 다시 입력해주세요.";
    
    private final HashMap<String, String> ladderGameResults;
    
    public LadderGameResults(final HashMap<String, String> ladderGameResults) {
        this.ladderGameResults = ladderGameResults;
    }
    
    public HashMap<String, String> getLadderGameResults() {
        return ladderGameResults;
    }
    
    public String get(final String playerName) {
        if (!ladderGameResults.containsKey(playerName)) {
            throw new IllegalArgumentException(NOT_EXIST_PLAYER_NAME_EXCEPTION_MESSAGE);
        }
        
        return ladderGameResults.get(playerName);
    }
}
