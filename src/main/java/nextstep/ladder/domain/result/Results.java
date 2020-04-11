package nextstep.ladder.domain.result;

import java.util.Collections;
import java.util.List;

public class Results {
    private final List<String> results;

    public Results(List<String> results) {
        this.results = Collections.unmodifiableList(results);
    }

    public String getResult(int idx){
        return null;
    }
}
