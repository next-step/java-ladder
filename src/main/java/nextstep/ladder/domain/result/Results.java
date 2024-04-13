package nextstep.ladder.domain.result;

import nextstep.ladder.domain.player.Count;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Results {
    private final List<Result> values;

    public static Results fromResultNames(List<String> values, Count playerCount) {
        return new Results(Stream.ofNullable(values)
                .flatMap(Collection::stream)
                .map(Result::new)
                .collect(Collectors.toList()), playerCount);
    }

    public Results(List<Result> values, Count playerCount) {
        assertExpectedSize(values, playerCount);

        this.values = values;
    }

    private void assertExpectedSize(List<Result> values, Count playerCount) {
        if (values == null || !playerCount.equals(values.size())) {
            throw new IllegalArgumentException("결과의 개수는 입력한 참여자 수와 동일해야 합니다.");
        }
    }

    public List<String> resultNames() {
        return values.stream()
                .map(Result::value)
                .collect(Collectors.toList());
    }

    public Count maxValueLength() {
        return new Count(values.stream()
                .mapToInt(Result::length)
                .max()
                .orElse(0));
    }
}
