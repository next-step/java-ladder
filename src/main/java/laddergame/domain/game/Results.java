package laddergame.domain.game;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Results {
    private final List<Result> results;

    public Results(final String[] resultNames) {
        validateResultNames(resultNames);
        results = createResults(resultNames);
    }

    private List<Result> createResults(final String[] resultNames) {
        return IntStream.range(0, resultNames.length)
                .mapToObj(column -> new Result(resultNames[column], column + 1))
                .collect(Collectors.toList());
    }

    private void validateResultNames(final String[] resultNames) {
        if (Objects.isNull(resultNames) || resultNames.length == 0) {
            throw new IllegalArgumentException("입력한 실행 결과들이 Null 또는 빈 배열입니다.");
        }
    }

    public Result findByColumn(final int findColumn) {
        return results.stream()
                .filter(result -> result.isSameColumn(findColumn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 열 번호가 없습니다. - " + findColumn));
    }
}
