package ladder.domain;

import java.util.List;

@FunctionalInterface
public interface LadderGenerator {
    List<Line> generate();
}
