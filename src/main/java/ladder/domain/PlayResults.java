package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayResults {
    private List<PlayResult> playResults;

    public PlayResults(List<String> playResults) {
        this.playResults = playResults.stream()
                .map(s -> PlayResult.of(s))
                .collect(Collectors.toList());
    }

    public List<PlayResult> getPlayResults() {
        return new ArrayList<>(this.playResults);
    }

    public int getCount() {
        return this.playResults.size();
    }
}
