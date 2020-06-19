package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderResults {

    public static final String RESULT_DELIMITER = ",";

    List<LadderResult> results = new ArrayList<>();

    public LadderResults(String ladderResults) {
        String[] resultArray = ladderResults.split(RESULT_DELIMITER);
        this.results = IntStream.range(0, resultArray.length)
                        .mapToObj(i -> new LadderResult(resultArray[i], i))
                        .collect(Collectors.toList());
    }

    public int getResultCount() {
        return results.size();
    }

    public LadderResult getResult(LadderResult selectorResult) {
        return results.stream()
                .filter(ladderResult -> ladderResult.equals(selectorResult))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public LadderResult getResultByPositionIndex(int index) {
        return results.stream()
                      .filter(ladderResult -> ladderResult.getPosition().getIndex() == index)
                      .findFirst()
                      .orElseThrow(IllegalArgumentException::new);
    }

    public List<String> resultInfo() {
        return results.stream()
                .map(LadderResult::getResultInfo)
                .collect(Collectors.toList());
    }

}
