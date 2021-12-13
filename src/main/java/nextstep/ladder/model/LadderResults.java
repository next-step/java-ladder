package nextstep.ladder.model;

import nextstep.ladder.model.value.LadderResult;
import nextstep.ladder.model.value.Participant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {

    private static final String DELIMITER = ",";

    private static List<LadderResult> ladderResults;

    private LadderResults(List<LadderResult> results) {

        this.ladderResults = results;
    }

    public static LadderResults of(String inputResults) {
        return new LadderResults(Arrays.stream(inputResults.split(DELIMITER))
                .map(String::trim)
                .map(LadderResult::new)
                .collect(Collectors.toList()));
    }

    public static List<LadderResult> getLadderResults() {
        return Collections.unmodifiableList(ladderResults);
    }

    public LadderResult get(Participant participant) {
        return ladderResults.get(participant.getPosition());
    }
}
