package nextstep.ladder.domain.game;

import java.util.List;
import java.util.Objects;

public class Results {

    private final List<Result> results;

    public Results(List<Result> results) {
        if (Objects.isNull(results)) {
            throw new IllegalArgumentException("inject result list is null from results class");
        }
        this.results = results;
    }

    public int size() {
        return results.size();
    }

    public Result get(int index) {
        return results.get(index);
    }
}
