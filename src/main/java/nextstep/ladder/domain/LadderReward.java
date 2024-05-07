package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderReward {
    private Location location;
    private List<String> results;

    public LadderReward(List<String> results) {
        this.results = results;
    }

    public String asString() {
        return results.stream()
                .collect(Collectors.joining("   ", " ", ""));
    }

    public String find(Integer i) {
        return results.get(location.indexOf(i));
    }

    public void runResult(Location location) {
        this.location = location;
    }

    public MatchingReward runReward(Location location) {
        this.location = location;
        return new MatchingReward(location);
    }

    public int size() {
        return results.size();
    }
}
