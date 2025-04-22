package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Results {
    private final List<Result> values;

    public Results(List<Result> values) {
        this.values = List.copyOf(values);
    }

    public static Results of(List<String> names, List<String> rewards) {
        List<Result> results =
                IntStream.range(0, names.size())
                        .mapToObj(i -> new Result(names.get(i), rewards.get(i)))
                        .collect(Collectors.toList());

        return new Results(results);
    }

    public List<String> printAll() {
        return values.stream()
                .map(Result::toString)
                .collect(Collectors.toList());
    }

    public String printTarget(String name) {
        return values.stream()
                .filter(result -> result.getName().equals(name))
                .map(Result::getReward)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 결과가 없습니다."));
    }
}
