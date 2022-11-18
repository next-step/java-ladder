package ladder.domain;

import ladder.strategy.ConnectionStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lines {

    private List<Line> lines = new ArrayList<>();

    public Lines(int size, int height, ConnectionStrategy connection) {
        IntStream.range(0, height)
                .forEach((i) -> this.lines.add(new Line(size, connection)));
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int nextIndex(Player player) {
        int playerIndex = player.index();
        for (Line line : this.lines) {
            playerIndex = line.nextIndex(playerIndex);
        }
        return playerIndex;
    }
}
