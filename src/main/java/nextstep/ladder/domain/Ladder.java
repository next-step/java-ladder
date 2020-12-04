package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static nextstep.ladder.utils.BinaryOperators.nope;

public class Ladder {
    private final List<IndexedName> goals;
    private final LadderLines ladderLines;

    public Ladder(List<Line> lines, List<IndexedName> goals) {
        this(new DefaultLadderLine(lines), goals);
    }

    public Ladder(LadderLines ladderLines, List<IndexedName> goals) {
        this.ladderLines = ladderLines;
        this.goals = goals;
    }

    public static Ladder of(Stream<Spoke> spokes) {
        return of(spokes, emptyList());
    }

    public static Ladder of(Stream<Spoke> spokes, List<IndexedName> goals) {
        return new Ladder(spokes.map(Line::new)
                                  .collect(toList()), goals);
    }

    public void forEach(Consumer<List<Boolean>> singleLineConsumer) {
        ladderLines.forEach(singleLineConsumer);
    }

    public Map<String, String> moveForAll(List<IndexedName> players) {
        return players.stream()
                .collect(toMap(IndexedName::toString, this::moveFor));
    }

    public Position moveOn(Position from) {
        return Position.of(ladderLines.move(from.toInt()));
    }

    String moveFor(IndexedName name) {
        int index = moveOn(Position.of(name)).toInt();
        return goals.get(index).toString();
    }

    static class DefaultLadderLine implements LadderLines {
        private final List<Line> lines;

        public DefaultLadderLine(List<Line> lines) {
            this.lines = lines;
        }

        @Override
        public int move(int index) {
            return lines.stream()
                    .reduce(Position.of(index), (position, line) -> line.moveOn(position), nope())
                    .toInt();
        }

        @Override
        public void forEach(Consumer<List<Boolean>> singleLineConsumer) {
            lines.forEach(line -> singleLineConsumer.accept(line.toSpokeList()));
        }
    }
}
