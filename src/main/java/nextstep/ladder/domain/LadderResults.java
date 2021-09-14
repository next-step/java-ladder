package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {

    private List<LadderResult> ladderResults;

    public LadderResults(String resultsString) {
        this.ladderResults = init(resultsString);
    }

    private List<LadderResult> init(String resultsString) {
        validResult(resultsString);
        String[] resultsArray = resultsString.split(",");
        return Arrays.stream(resultsArray)
                .map(player -> new LadderResult(player))
                .collect(Collectors.toList());
    }

    private void validResult(String resultsString) {
        if(resultsString == null) {
            throw new IllegalArgumentException("입력한 결과가 비어있습니다.");
        }
    }

    public int countOfLadderResults() {
        return ladderResults.size();
    }

    public String indexOf(int index) {
        return ladderResults.get(index).getResult();
    }

    public List<LadderResult> getLadderResults() {
        return ladderResults;
    }
}
