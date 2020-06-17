package ladder.domain.result;

import ladder.domain.player.Players;
import ladder.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {

    private final List<LadderResult> results;

    private LadderResults(List<LadderResult> results) {
        this.results = results;
    }

    public static LadderResults of(String input, Players players) {
        StringUtils.validate(input);
        LadderResults ladderResults = new LadderResults(Arrays
                .stream(StringUtils.splitByComma(input))
                .map(LadderResult::of)
                .collect(Collectors.toList()));
        validateSize(ladderResults, players);
        return ladderResults;
    }

    private static void validateSize(LadderResults ladderResults, Players players) {
        if (ladderResults.size() != players.getCountOfPerson()) {
            throw new IllegalArgumentException("Participants and results have different sizes.");
        }
    }

    public LadderResult get(int index) {
        return results.get(index);
    }

    public int size() {
        return results.size();
    }
}
