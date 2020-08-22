package ladder.domain;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResults implements Iterable<LadderResult>, Printable {

    private final List<LadderResult> ladderResults;

    private LadderResults(List<LadderResult> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public static LadderResults fromText(String text) {
        List<LadderResult> ladderResults = new ArrayList<>();
        CommaSplitter.split(text)
                .forEach(s -> ladderResults.add(new LadderResult(s)));
        return new LadderResults(ladderResults);
    }

    public int size() {
        return ladderResults.size();
    }

    @Nonnull
    @Override
    public Iterator<LadderResult> iterator() {
        return ladderResults.iterator();
    }

    @Override
    public String print() {
        return ladderResults.stream()
                .map(LadderResult::print)
                .collect(Collectors.joining(" "));
    }
}
