package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lines;
    private int height;

    public Ladder(LadderRecord ladderRecord, int height) {
        this.height = height;
        this.lines = createLines(ladderRecord.getWidth());
    }

    public List<Line> createLines(int width) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(new PointCreatingStrategy(), width));
        }
        return lines;
    }

    public List<String> drawLadder() {
        List<String> ladderFormat = new ArrayList<>();
        for (Line line : lines) {
            ladderFormat.add(line.drawLine());
        }
        return ladderFormat;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeight() {
        return height;
    }

}
