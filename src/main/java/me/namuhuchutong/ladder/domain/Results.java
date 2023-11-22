package me.namuhuchutong.ladder.domain;

import me.namuhuchutong.ladder.domain.wrapper.Result;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class Results {

    private static final String COMMA_REGEX = ",";

    private final List<Result> results;

    public static Results from(String results) {
        List<Result> collect = Arrays.stream(results.split(COMMA_REGEX))
                                     .map(Result::new)
                                     .collect(toUnmodifiableList());
        return new Results(collect);
    }

    public Results(List<Result> results) {
        this.results = results;
    }

    public String getResults(String format) {
        return this.results.stream()
                           .map(Result::getResult)
                           .map(resultName -> String.format(format, resultName))
                           .reduce("", (previous, newOne) -> previous + newOne);
    }

    public Result getNthResult(Integer index) {
        validateIndex(index);
        return this.results.get(index);
    }

    private void validateIndex(Integer index) {
        if (index < 0 || isBiggerThanSize(index)) {
            throw new IllegalArgumentException("인덱스가 실행결과 수의 범위를 벗어났습니다. -" + index);
        }
    }

    private boolean isBiggerThanSize(Integer index) {
        return this.results.size() - 1 < index;
    }
}
