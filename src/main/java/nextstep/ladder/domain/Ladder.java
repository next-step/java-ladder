package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static nextstep.ladder.utils.BinaryOperators.nope;

public class Ladder {
    private final List<Line> lines;
    private final List<IndexedName> goals;

    public Ladder(List<Line> lines, List<IndexedName> goals) {
        this.lines = lines;
        this.goals = goals;
    }

    public static Ladder of(Stream<Spoke> spokes) {
        return of(spokes, emptyList());
    }

    public static Ladder of(Stream<Spoke> spokes, List<IndexedName> goals) {
        return new Ladder(spokes.map(Line::new)
                                  .collect(toList()), goals);
    }

    public void forEach(Consumer<Line> singleLineConsumer) {
        lines.forEach(singleLineConsumer);
    }

    public List<String> getGoals() {
        return Collections.unmodifiableList(IndexedName.unwrap(goals));
    }

    public Map<String, String> moveForAll(List<IndexedName> players) {
        return players.stream()
                .collect(toMap(IndexedName::toString, this::moveFor));
    }

    public Position moveOn(Position from) {
        return lines.stream()
                .reduce(from, (position, line) -> line.moveOn(position), nope());
    }

    String moveFor(IndexedName name) {
        int index = moveOn(Position.of(name)).toInt();
        return goals.stream()
                .filter(goal -> goal.equalsIndex(index))
                .findFirst()
                .map(IndexedName::toString)
                .orElse("");
    }
}
