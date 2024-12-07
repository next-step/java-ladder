package nextstep.laddergame.service;

import nextstep.laddergame.domain.Line;

import java.util.List;

@FunctionalInterface
public interface LineGenerator {
    Line generate(int lineCount);

    default boolean isAllNonSet(List<Boolean> lines) {
        return lines.stream().noneMatch(line -> line);
    }
}
