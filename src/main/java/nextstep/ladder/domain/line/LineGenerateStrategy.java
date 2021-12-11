package nextstep.ladder.domain.line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import nextstep.ladder.domain.PlayerCount;

@FunctionalInterface
public interface LineGenerateStrategy {
    LineGenerateStrategy NO_LINE_STRATEGY = number -> Stream.generate(() -> Boolean.FALSE)
            .limit(number.toInt())
            .collect(Collectors.toList());

    List<Boolean> generate(final PlayerCount playerCount);
}