package ladder.domain.result;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderResults {
    private static final String RESULT_DELIMITER = ",";

    private final List<LadderResult> ladderResults;

    public LadderResults(String results) {
        this.ladderResults = Stream.of(results.split(RESULT_DELIMITER))
                        .map(result -> result.trim())
                        .map(result -> new LadderResult(result))
                        .collect(Collectors.toList());
    }

    public String showResult(int position) {
        return ladderResults.get(position).showResult();
    }

    public List<LadderResult> showLadderResults(){
        return ladderResults;
    }
}
