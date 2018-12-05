package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PlayResults {

    private final List<PlayResult> results = new ArrayList<>();

    void add(PlayResult playResult) {
        results.add(playResult);
    }

    List<PlayResult> getResults() {
        return Collections.unmodifiableList(results);
    }
}
