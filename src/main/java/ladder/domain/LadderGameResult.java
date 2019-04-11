package ladder.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class LadderGameResult {
    private GameResults inputGameResults;
    private PlayResults playResults;

    public LadderGameResult(List<String> inputResults) {
        inputGameResults = new GameResults(inputResults);
    }

    public void initPlayResults(PlayResults playResults) {
        this.playResults = playResults;
    }

    public PlayResult findResultByName(String inputUserResult) {
        return playResults.findResultByName(inputUserResult);
    }
}
