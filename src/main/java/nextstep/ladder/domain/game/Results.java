package nextstep.ladder.domain.game;

import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public int size(){
        return results.size();
    }
}
