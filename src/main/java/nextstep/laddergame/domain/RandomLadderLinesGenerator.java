package nextstep.laddergame.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLadderLinesGenerator implements LadderLinesGenerator {
    private final Random random = new Random();

    @Override
    public Lines generate(Optional<Ladder> beforeLadder, int maxHeight) {
        List<Boolean> newLines = IntStream.range(0, maxHeight)
                .mapToObj(lineIndex ->
                        beforeLadder.isPresent() && beforeLadder.get().isLineAlreadySetAt(lineIndex)
                                ? Boolean.FALSE
                                : random.nextBoolean()
                ).collect(Collectors.toList());

        if (isAllNonSet(newLines)) {
            return generate(beforeLadder, maxHeight);
        }
        return new Lines(newLines);
    }

}
