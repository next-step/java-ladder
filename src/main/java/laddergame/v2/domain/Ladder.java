package laddergame.v2.domain;

import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int move(int position){
        int current = position;
        for(Line line : lines){
            current = line.move(current);
        }
        return current;
    }

    public List<Line> getLines() {
        return lines;
    }
}
