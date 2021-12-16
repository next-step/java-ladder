package nextstep.ladder.domain.line;

import java.util.List;

import nextstep.ladder.domain.Count;

@FunctionalInterface
public interface LineGenerateStrategy {
    List<Boolean> generate(final Count count);
}