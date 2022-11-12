package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Results {

    List<String> results = new ArrayList<>();

    public Results(List<String> results, int size) {
        if (results.size() != size) {
            throw new IllegalArgumentException("참여할 사람 수만큼 결과를 입력해 주세요.");
        }
        this.results = results;
    }

    public List<String> getResults() {
        return results;
    }
}
