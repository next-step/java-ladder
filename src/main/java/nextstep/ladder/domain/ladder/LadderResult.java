package nextstep.ladder.domain.ladder;

import java.util.Map;

public class LadderResult {
    private final Map<Location, Location> results;

    public LadderResult(final Map<Location, Location> results) {
        this.results = results;
    }

    public Location getFinalLocation(Location startLocation) {
        return results.get(startLocation);
    }
}
