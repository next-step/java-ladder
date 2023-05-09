package ladder.model;

import java.util.List;
import java.util.function.Consumer;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class LadderResults {

    private final List<LadderResult> ladderResults;

    public LadderResults(List<LadderResult> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public static LadderResults of(String... results) {
        return new LadderResults(stream(results)
                .map(LadderResult::new)
                .collect(toList())
        );
    }

    public int size() {
        return ladderResults.size();
    }

    public void forEach(Consumer<? super LadderResult> action) {
        ladderResults.forEach(action);
    }
}
