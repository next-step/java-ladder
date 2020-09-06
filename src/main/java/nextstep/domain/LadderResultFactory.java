package nextstep.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResultFactory {

    public static final String DELIMITER = ",";

    public static List<LadderResult> createLadderResults(String line) {
        return createLadderResults(line.split(DELIMITER));
    }

    public static List<LadderResult> createLadderResults(String[] ladderResults) {
        return Arrays.stream(ladderResults)
                .map(LadderResult::new)
                .collect(Collectors.toList());
    }

}
