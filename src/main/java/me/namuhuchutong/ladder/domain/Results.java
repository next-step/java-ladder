package me.namuhuchutong.ladder.domain;

import me.namuhuchutong.ladder.domain.wrapper.Result;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class Results {

    private final List<Result> results;

    public static Results from(String results) {
        List<Result> collect = Arrays.stream(results.split(","))
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
}
