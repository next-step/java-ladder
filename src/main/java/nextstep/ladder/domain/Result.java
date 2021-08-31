package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextstep.ladder.domain.Players.*;

public class Result {
    private List<String> result;

    public Result(String input) {
        this(toList(input));
    }

    public static List<String> toList(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public Result(List<String> result) {
        this.result = result;
    }

    public int size() {
        return result.size();
    }

    public String get(int index) {
        return result.get(index);
    }

    public Stream<String> stream() {
        return result.stream();
    }
}
