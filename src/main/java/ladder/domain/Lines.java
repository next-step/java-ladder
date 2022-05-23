package ladder.domain;

import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public void draw() {
        this.lines.forEach(line -> {
            System.out.print(" ".repeat(4) + "|");
            line.draw();
            System.out.println();
        });
    }
}
