package nextstep.ladder.model;

import java.util.Map;

public class GameResult {
    private final Map<String, String> gameResult;

    public GameResult(Map<String, String> gameResult) {
        this.gameResult = gameResult;
    }

    public String getPeopleResult(String name) {
        isJoinedPersonName(name);
        return gameResult.get(name);
    }

    private void isJoinedPersonName(String name) {
        if (!gameResult.containsKey(name)) {
            throw new IllegalArgumentException("게임에 참여한 사람이 아닙니다");
        }
    }

    public Map<String,String> gameResult(){
        return this.gameResult;
    }
}
