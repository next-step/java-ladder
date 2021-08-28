package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> getResult() {
        return result;
    }
}
