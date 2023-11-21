package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(List<String> results, int gameMemberCount) {
        validate(results.size(), gameMemberCount);

        this. results = results.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

    public Result getResult(int index) {
        return this.results.get(index);
    }

    private void validate(int resultSize, int gameMemberCount) {
        if (resultSize != gameMemberCount) {
            throw new IllegalArgumentException("게임 참여자 수와 결과의 수는 동일해야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results1 = (Results) o;
        return Objects.equals(results, results1.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
