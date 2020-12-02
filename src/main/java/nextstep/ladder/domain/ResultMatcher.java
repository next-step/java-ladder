package nextstep.ladder.domain;

import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultMatcher {

    public static Matches match(PlayersOnLine playersOnLine, Results results) {
        return IntStream.range(0, results.getSize())
                .mapToObj(idx -> new SimpleEntry<>(playersOnLine.get(idx), results.get(idx)))
                .collect(Collectors.collectingAndThen(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue), Matches::new));
    }
}
