package ladder.domain;

import ladder.exception.LineListNullPointerException;
import ladder.strategy.LineGenerateStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Ladder {

    private static final int START_INCLUSIVE = 0;

    private final List<Line> ladder;

    public static final Ladder from(LadderCreationInformation creationInformation, LineGenerateStrategy strategy) {
        return from(IntStream.range(START_INCLUSIVE, creationInformation.width())
                .mapToObj(i -> Line.of(creationInformation.height(), strategy))
                .collect(Collectors.toList())
        );
    }

    public static final Ladder from(List<Line> ladder) {
        return new Ladder(ladder);
    }

    public Ladder(List<Line> ladder) {
        validateNull(ladder);
        this.ladder = ladder;
    }

    private final void validateNull(List<Line> ladder) {
        if (Objects.isNull(ladder)) {
            throw new LineListNullPointerException();
        }
    }

    public final LadderResultBoard run(People people, LadderResults results) {
        List<Integer> list = people.values();
        ladder.forEach(line -> line.run(list));

        Map<Person, String> map = new HashMap<>();
        IntStream.range(START_INCLUSIVE, list.size())
                .forEach(index -> {
                    Person person = people.get(list.get(index));
                    String result = results.get(index);
                    map.put(person, result);
                });
        return LadderResultBoard.of(map);
    }

    public final Stream<Line> stream() {
        return ladder.stream();
    }
}
