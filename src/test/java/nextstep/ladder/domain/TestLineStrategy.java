package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import nextstep.ladder.domain.line.LineGenerateStrategy;

public class TestLineStrategy {
    public static LineGenerateStrategy NO_LINE_STRATEGY = number -> Stream.generate(() -> Boolean.FALSE)
            .limit(number.toInt())
            .collect(Collectors.toList());

    public static LineGenerateStrategy VALID_STRATEGY = new LineGenerateStrategy() {
        @Override
        public List<Boolean> generatePoints(Count count) {
            flag = true;
            return Stream.generate(this::reverseFlag)
                    .limit(count.toInt())
                    .collect(Collectors.toList());
        }

        private boolean flag;
        private boolean reverseFlag() {
            flag = !flag;
            return flag;
        }
    };

    public static LineGenerateStrategy ALL_LINE_STRATEGY = number -> Stream.generate(() -> Boolean.TRUE)
            .limit(number.toInt())
            .collect(Collectors.toList());

    public static LineGenerateStrategy INVALID_TRUE_IN_SUCCESSION_STRATEGY = number -> IntStream.range(0, number.toInt())
            .mapToObj(num -> num % 3 != 0)
            .collect(Collectors.toList());
}
