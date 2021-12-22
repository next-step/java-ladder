package nextstep.ladder.model;

import java.util.List;

public class Lines {

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public void move(Player player) {
        lines.forEach(line -> line.move(player));
    }

    public List<Line> getLines() {
        return lines;
    }
}
