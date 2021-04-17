package nextstep.ladder;

import nextstep.ladder.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Results {
    private final static int MIN_RESULTS = 2;
    private final List<Result> results;

    private Results(String[] values) {
        validation(values);
        this.results = generateResults(values);
    }

    private void validation(String[] values) {
        if (values.length < MIN_RESULTS) {
            throw new IllegalArgumentException("최소 결과 개수는 2개 이상이어야 합니다.");
        }
    }

    public static Results from(String value) {
        return new Results(StringUtils.stringToArray(value));
    }

    private List<Result> generateResults(String[] values) {
        return IntStream.range(0, values.length)
                .mapToObj(position -> Result.of(values[position].trim(), position))
                .collect(Collectors.toList());
    }

    public List<String> values() {
        return results.stream()
                .map(Result::value)
                .collect(Collectors.toList());
    }

    public String result(int position) {
        return results.get(position)
                .value();
    }

    public int size() {
        return results.size();
    }
}
