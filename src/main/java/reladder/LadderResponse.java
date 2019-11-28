package reladder;

import reladder.service.LadderGame;

import java.util.Map;

public class LadderResponse {

    private LadderGame ladderGame;
    private String result;
    private Map<String, Object> resultAll;
    public LadderResponse(LadderGame ladderGame) {
        this.ladderGame = ladderGame;
    }

    public LadderResponse(String result) {
        this.result = result;
    }

    public LadderResponse(Map<String, Object> resultAll) {
        this.resultAll = resultAll;
    }

    public LadderGame getLadderGame() {
        return ladderGame;
    }

    public String getResult() {
        return result;
    }

    public Map<String, Object> getResultAll() {
        return resultAll;
    }
}
