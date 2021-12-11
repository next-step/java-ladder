package nextstep.ladder.domain.line;

import java.util.List;

import nextstep.ladder.domain.LineCount;

@FunctionalInterface
public interface LineGenerateStrategy {
    List<Boolean> generate(final LineCount lineCount);
}