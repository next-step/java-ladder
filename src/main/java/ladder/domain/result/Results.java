package ladder.domain.result;

import ladder.domain.player.Name;

import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        validate(results);
        this.results = results;
    }

    private void validate(List<Result> results) {
        if (results == null || results.isEmpty()) {
            throw new IllegalArgumentException("results는 빈 값일 수 없습니다.");
        }
    }

    public List<Result> getResults() {
        return results;
    }

    public Result findByPlayerName(Name name) {
        return results.stream()
                .filter(result -> result.player().isSameName(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("플레이어가 존재하지 않습니다."));
    }
}
