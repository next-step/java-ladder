package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static java.util.stream.Collectors.toMap;

public class Ladder {
    private final List<IndexedName> goals;
    private final LadderLines ladderLines;

    public Ladder(LadderLines ladderLines, List<IndexedName> goals) {
        this.ladderLines = ladderLines;
        this.goals = goals;
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

}
