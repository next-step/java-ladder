package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Results {
    private List<String> results;

    private Results(List<String> results) {
        this.results = new ArrayList<>(results);
    }

    public static Results of(Participants participants, List<String> results) {
        if (participants.size() != results.size()) {
            throw new IllegalArgumentException("참여인원과 결과값의 수가 다릅니다.");
        }
        return new Results(results);
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(results);
    }

}
