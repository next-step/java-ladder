package ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Result {

    private String result;

    public Result(String result) {
        this.result = result;
    }

    private static final int MAX_NAME_LENGTH = 5;

    @Override
    public String toString() {
        String str = IntStream.range(0, MAX_NAME_LENGTH - this.result.length())
                .mapToObj(i -> " ")
                .collect(Collectors.joining("", this.result, " "));

        return str;
    }
}
