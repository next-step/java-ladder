package laddergame.service;

import laddergame.domain.LadderLine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLinesGenerator {

    public static List<LadderLine> generate(final int sizeOfPerson, int maximumHeight) {
        return IntStream.rangeClosed(1, maximumHeight)
                        .mapToObj($ -> LadderLine.init(sizeOfPerson))
                        .collect(Collectors.toList());
    }
}