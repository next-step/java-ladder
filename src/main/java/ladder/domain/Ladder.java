package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(Players players, Height height) {
        this.lines = init(players.countOfPlayers(), height.get());
    }

    public List<Line> init(int countOfPlayers, int height) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, height).forEach((i)-> lines.add(new Line(new RandomPoints(countOfPlayers))));
        return lines;
    }

    public int countOfLine() {
        return lines.size();
    }

    public List<Line> get() {
        return lines;
    }
}
