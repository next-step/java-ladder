package laddergame.service;

import laddergame.domain.LadderLine;
import laddergame.domain.Level;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLinesGenerator {
    public static List<LadderLine> generate(int sizeOfPerson, Level level) {
        return IntStream.rangeClosed(1, level.getMaximumHeight())
                        .mapToObj($ -> LadderLine.init(sizeOfPerson, level))
                        .collect(Collectors.toList());
    }
}