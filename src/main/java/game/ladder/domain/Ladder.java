package game.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by yusik on 2019/11/11.
 */
public class Ladder {

    private final List<Line> lines;
    private final List<String> players;

    public Ladder(List<String> names, int height) {
        this.players = names;
        int countOfPlayer = players.size();
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(countOfPlayer))
                .collect(toList());
    }

    public List<String> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
