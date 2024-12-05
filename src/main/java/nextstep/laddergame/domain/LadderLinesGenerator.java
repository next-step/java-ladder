package nextstep.laddergame.domain;

import java.util.List;
import java.util.Optional;

@FunctionalInterface
public interface LadderLinesGenerator {
    Lines generate(Optional<Ladder> beforeLadder, int maxHeight);

    default boolean isAllNonSet(List<Boolean> lines) {
        return lines.stream().noneMatch(line -> line);
    }
}
