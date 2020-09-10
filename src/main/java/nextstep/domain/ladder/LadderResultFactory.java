package nextstep.domain.ladder;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LadderResultFactory {

    public static final String DELIMITER = ",";

    public static LadderResults createLadderResults(String line) {
        return createLadderResults(line.split(DELIMITER));
    }

    public static LadderResults createLadderResults(String[] ladderResults) {
        return new LadderResults(Arrays.stream(ladderResults)
                .map(LadderResult::new)
                .collect(Collectors.toList()));
    }

}
