package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static nextstep.ladder.utils.BinaryOperators.nope;

public class Ladder {
    private final List<Line> lines;
    private final List<String> players;
    private final List<String> goals;

    public Ladder(List<Line> lines, List<String> players, List<String> goals) {
        this.lines = lines;
        this.players = players;
        this.goals = goals;
    }

    public static Ladder of(Stream<Spoke> spokes) {
        return of(spokes, emptyList(), emptyList());
    }

    public static Ladder of(Stream<Spoke> spokes, List<String> names, List<String> goals) {
        return new Ladder(spokes.map(Line::new)
                                  .collect(toList()), names, goals);
    }

    public void forEach(Consumer<Line> singleLineConsumer) {
        lines.forEach(singleLineConsumer);
    }

    public List<String> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<String> getGoals() {
        return Collections.unmodifiableList(goals);
    }

    public String moveFor(String playerName) {
        return goals.get(moveOn(Position.of(players.indexOf(playerName))).toInt());
    }

    public Map<String, String> moveForAll() {
        return players.stream()
                .collect(toMap(identity(), this::moveFor));
    }

    public Position moveOn(Position from) {
        return lines.stream()
                .reduce(from, (position, line) -> line.moveOn(position), nope());
    }
}
