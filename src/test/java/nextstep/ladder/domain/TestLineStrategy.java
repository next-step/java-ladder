package nextstep.ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import nextstep.ladder.domain.line.LineGenerateStrategy;

public class TestLineStrategy {
    public static LineGenerateStrategy INVALID_ALL_LINE_STRATEGY = number -> Stream.generate(() -> Boolean.TRUE)
            .limit(number)
            .collect(Collectors.toList());

    public static LineGenerateStrategy INVALID_TRUE_IN_SUCCESSION_STRATEGY = number -> IntStream.range(0, number)
            .mapToObj(num -> num % 3 != 0)
            .collect(Collectors.toList());
}
