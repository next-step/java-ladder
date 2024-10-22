package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int playerCount, int height, LadderLineGenerator generator) {
        this(createLines(playerCount, height, generator));
    }

    public Ladder(List<Line> lines){
        this.lines = lines;
    }

    private static List<Line> createLines(int playerCount, int height, LadderLineGenerator generator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(playerCount, generator));
        };
        return lines;
    }

    public int moveDownByPosition(int startPosition) {
        int currentPosition = startPosition;
        for (Line line : lines) {
            currentPosition = line.move(currentPosition);
        }
        return currentPosition;
    }

    public int size() {
        return lines.size();
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
