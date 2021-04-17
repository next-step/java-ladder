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

    public static final Ladder from(List<Line> ladder) {
        return new Ladder(ladder);
    }

    public static final Ladder from(People people, LadderHeight height, LineGenerateStrategy strategy) {
        return from(IntStream.range(START_INCLUSIVE, height.toInt())
                .mapToObj(i -> Line.of(people.size(), strategy))
                .collect(Collectors.toList())
        );
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

    public final Map<String, String> run(People people, LadderResults results) {
        List<Integer> list = people.values();
        ladder.forEach(line -> line.run(list));
        Map<String, String> map = new HashMap<>();
        IntStream.range(START_INCLUSIVE, list.size())
                .forEach(index -> {
                    Person person = people.get(list.get(index));
                    String result = results.get(index);
                    map.put(person.getName(), result);
                });
        return map;
    }

    public final Stream<Line> stream() {
        return ladder.stream();
    }
}
