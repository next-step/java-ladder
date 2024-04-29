package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {
    private Location location;
    private List<String> results;

    public LadderResult(List<String> results) {
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

    public int size() {
        return results.size();
    }
}
