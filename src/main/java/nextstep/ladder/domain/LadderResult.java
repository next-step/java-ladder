package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderResult {

    private final List<String> results;

    public LadderResult(List<String> results) {
        this.results = results;
    }

    public String getResult(int position) {
        return results.get(position);
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(results);
    }

    public boolean isMatchedWithParticipants(Participants participants) {
        return results.size() == participants.size();
    }
}
