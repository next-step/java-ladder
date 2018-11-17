package game.ladder.domain;

import java.util.List;

public class Lines {

    private final List<Line> lines;
    private final Height height;

    public Lines(List<Line> lines) {
        this.lines = lines;
        this.height = new Height(lines.size());
    }

    public Height getHeight() {
        return this.height;
    }

    public String getStringLines() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lines) {
            sb.append(line.getStringLine()).append(System.lineSeparator());
        }
        return sb.toString();
    }

}
