package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(Players players, Height height, PointGenerationStrategy strategy) {
        this.lines = createLadder(players, height, strategy);
    }

    private List<Line> createLadder(Players players, Height height, PointGenerationStrategy strategy) {
        int countOfPlayers = players.getPlayersCount();

        return IntStream.range(0, height.getHeight())
                .mapToObj(num -> new Line(countOfPlayers, strategy))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}
