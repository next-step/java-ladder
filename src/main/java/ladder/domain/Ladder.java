package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(Players players, Height height) {
        return new Ladder(init(players.countOfPlayers(), height.get()));
    }

    private static List<Line> init(int countOfPlayers, int height) {
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
