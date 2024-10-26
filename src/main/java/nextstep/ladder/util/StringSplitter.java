package nextstep.ladder.util;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringSplitter {

    private static final String DELIMITER = ",";

    private List<String> split;

    public StringSplitter(String toSplit) {
        String[] split = Optional.ofNullable(toSplit)
                .filter(string -> !string.isBlank())
                .orElseThrow(() ->
                        new IllegalArgumentException("문자열에 공백 또는 null은 허용되지 않습니다."))
                .split(DELIMITER);
        this.split = Stream.of(split)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public <T> List<T> indexBasedConverter(BiFunction<Integer, String, T> producer) {
        return IntStream.range(0, split.size())
                .mapToObj(i -> producer.apply(i, split.get(i)))
                .collect(Collectors.toList());
    }

    public List<String> getSplit() {
        return split;
    }
}
