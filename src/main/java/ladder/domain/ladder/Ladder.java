package ladder.domain.ladder;

import ladder.domain.participant.People;
import ladder.domain.participant.Person;
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

    private Ladder(List<Line> ladder) {
        validateNull(ladder);
        this.ladder = ladder;
    }

    public static final Ladder from(People people, LadderHeight height, LineGenerateStrategy strategy) {
        return from(IntStream.range(START_INCLUSIVE, height.height())
                .mapToObj(i -> Line.of(people, strategy))
                .collect(Collectors.toList())
        );
    }

    private final void validateNull(List<Line> ladder) {
        if (Objects.isNull(ladder)) {
            throw new LineListNullPointerException();
        }
    }

    public final LadderResultBoard run(People people, LadderResults results) {
        List<Integer> list = results.values();
        ladder.forEach(line -> line.run(list));

        Map<Person, String> map = new HashMap<>();
        IntStream.range(START_INCLUSIVE, list.size())
                .forEach(index -> {
                    Person person = people.person(list.get(index));
                    String result = results.get(index);
                    map.put(person, result);
                });

        return LadderResultBoard.of(map);
    }

    public final Stream<Line> stream() {
        return ladder.stream();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(ladder, ladder1.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }
}
