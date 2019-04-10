package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGameResult {

    private List<String> inputGameResults = new ArrayList<>();
    private PlayResults playResults;

    public LadderGameResult(List<String> inputResults) {
        inputGameResults.addAll(inputResults);
    }

    public void initPlayerResults(List<PlayResult> playResults) {
        this.playResults = new PlayResults(playResults);
    }

    public String getPlayResults(String userName) {
        if(userName.equals("all")) {
            return getAllPlayResults();
        }
        return getPlayResult(userName);
    }

    private String getPlayResult(String userName) {
        PlayResult playResult = playResults.findResultByName(userName);
        return inputGameResults.get(playResult.getResultIndex());
    }

    private String getAllPlayResults() {
        StringBuilder stringBuilder = new StringBuilder("");
        playResults.getPlayResults().forEach(playResult -> {
            String template = String.format("%s : %s \n", playResult.getName(), inputGameResults.get(playResult.getResultIndex()));
            stringBuilder.append(template);
        });
        return stringBuilder.toString();
    }
}
