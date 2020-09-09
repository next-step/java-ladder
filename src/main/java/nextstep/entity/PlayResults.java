package nextstep.entity;

import java.util.ArrayList;
import java.util.List;

public class PlayResults {

    private final List<PlayResult> playResults;

    private PlayResults(List<PlayResult> playResults) {
        this.playResults = new ArrayList(playResults);
    }

    public String findArrivalName(String startName) {
        return playResults.stream()
                .filter(playResult -> playResult.isEqualEntry(startName))
                .findAny()
                .get()
                .getArrivalName();
    }

    public static PlayResults of(List<PlayResult> playResults) {
        return new PlayResults(playResults);
    }
}
