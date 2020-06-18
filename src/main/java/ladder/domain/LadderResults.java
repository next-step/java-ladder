package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {

    public static final String RESULT_DELIMITER = ",";

    List<LadderResult> results = new ArrayList<>();

    public LadderResults(String ladderResults) {
        this.results = Arrays.stream(ladderResults.split(RESULT_DELIMITER))
                        .map(LadderResult::new)
                        .collect(Collectors.toList());
    }

    public int getResultCount() {
        return results.size();
    }

}
