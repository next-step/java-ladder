package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static nextstep.ladder.domain.IndexedName.wrap;
import static nextstep.ladder.utils.BinaryOperators.nope;

public class Ladder {
    private final List<Line> lines;
    private List<String> players;
    private final List<IndexedName> goals;

    public Ladder(List<Line> lines, List<IndexedName> goals) {
        this.lines = lines;
        this.goals = goals;
    }

    public static Ladder of(Stream<Spoke> spokes) {
        return of(spokes, emptyList(), emptyList());
    }

    public static Ladder of(Stream<Spoke> spokes, List<String> names, List<String> goals) {
        return of(spokes, wrap(goals));
    }

    public static Ladder of(Stream<Spoke> spokes, List<IndexedName> goals) {
        return new Ladder(spokes.map(Line::new)
                                  .collect(toList()), goals);
    }

    public void forEach(Consumer<Line> singleLineConsumer) {
        lines.forEach(singleLineConsumer);
    }

    public List<String> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<String> getGoals() {
        return Collections.unmodifiableList(goals.stream().map(Object::toString).collect(toList()));
    }

    @Deprecated
    public String moveFor(String playerName) {
        int index = moveOn(Position.of(players.indexOf(playerName))).toInt();
        return goals.stream().filter(goals -> goals.getIndex() == index).findFirst().toString();
    }

    @Deprecated
    public Map<String, String> moveForAll() {
        return players.stream()
                .collect(toMap(identity(), this::moveFor));
    }

    public Position moveOn(Position from) {
        return lines.stream()
                .reduce(from, (position, line) -> line.moveOn(position), nope());
    }

    public String moveFor(IndexedName name) {
        int index = moveOn(Position.of(name)).toInt();
        return goals.stream()
                .filter(goals -> goals.getIndex() == index)
                .findFirst()
                .map(Objects::toString)
                .orElse("");
    }
}
