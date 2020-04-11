package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayResults {
    private static final int RULE_PLAY_RESULT_MIN_COUNT = 2;
    private List<PlayResult> playResults;

    public PlayResults(List<String> inputs) {
        int playResultsCount = inputs.size();
        validate(playResultsCount);
        this.playResults = inputsToPlayerResults(inputs);
    }

    public List<PlayResult> getPlayResults() {
        return new ArrayList<>(this.playResults);
    }

    public int count() {
        return this.playResults.size();
    }

    public String getResult(int index) {
        return this.playResults.get(index).getResult();
    }

    private List<PlayResult> inputsToPlayerResults(List<String> inputs) {
        List<PlayResult> playResults = new ArrayList<>();
        for (String input : inputs) {
            playResults.add(PlayResult.of(input));
        }
        return playResults;
    }

    private void validate(int playResultCount) {
        if (playResultCount < RULE_PLAY_RESULT_MIN_COUNT) {
            throw new IllegalArgumentException(String.format("플레이어는 %d명 이상이어야 합니다.", RULE_PLAY_RESULT_MIN_COUNT));
        }
    }
}
