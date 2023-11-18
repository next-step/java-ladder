package me.namuhuchutong.ladder.domain;

import me.namuhuchutong.ladder.domain.wrapper.Result;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Results {

    private final List<Result> results;

    public static Results from(String inputResults) {
        String[] split = inputResults.split(",");
        List<Result> collect = Arrays.stream(split)
                                     .map(Result::new)
                                     .collect(toUnmodifiableList());
        return new Results(collect);
    }

    public Results(List<Result> results) {
        this.results = results;
    }
}
