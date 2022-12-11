package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayResults {

    private final Map<Integer, Integer> results;

    public PlayResults(final List<PlayResult> results) {
        this.results = results.stream()
                .collect(Collectors.toMap(PlayResult::getSource, PlayResult::getTarget, (a, b) -> b));
    }

    public int getTarget(final int position) {
        return results.get(position);
    }
}
