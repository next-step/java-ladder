package nextstep.ladder.domain.ladder.line.strategy;

import nextstep.ladder.domain.ladder.line.HorizontalLine;

import java.util.List;

public interface HorizontalLinesGenerateStrategy {
    List<HorizontalLine> generate(int size);
}
