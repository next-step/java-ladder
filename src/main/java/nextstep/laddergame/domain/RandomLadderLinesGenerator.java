package nextstep.laddergame.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLadderLinesGenerator implements LadderLinesGenerator {
    private final Random random = new Random();

    @Override
    public Lines generate(Optional<Ladder> beforeLadder, int maxHeight) {
        List<Boolean> newLines = IntStream.range(0, maxHeight)
                .mapToObj(floor ->
                        beforeLadder.filter(ladder -> ladder.isLineAlreadySetAt(floor))
                                .map(ladder -> Boolean.FALSE)
                                .orElseGet(random::nextBoolean))
                .collect(Collectors.toList());

        if (isAllNonSet(newLines)) {
            return generate(beforeLadder, maxHeight);
        }
        return new Lines(newLines);
    }

}
