package nextstep.ladder.domain;

import java.util.ArrayList;

import nextstep.ladder.exception.LineException;

public class Ladder {
    private final ArrayList<Line> lines = new ArrayList<>();
    private final Height height;

    public Ladder(final int countOfPerson, final Height height) {
        this.height = height;
        initialize(countOfPerson, height);
    }

    private void initialize(final int countOfPerson, final Height height) {
        Height h = Height.copyOf(height);
        while (!h.isZero()) {
            lines.add(new Line(countOfPerson));
            h.decrease();
        }
    }

    public ArrayList<Line> makeLadder(Draw draw) {
        for (Line line : lines) {
            makeLine(line, draw);
        }
        return lines;
    }

    public void makeLine(final Line line, final Draw draw) {
        for (int i = 0; i <= line.getMaxPointPosition(); i++) {
            try {
                line.makeBridge(i, draw);
            } catch (LineException e) {

            }
        }
    }

    public boolean isMaxHeight(final Height height) {
        return this.height == height;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }
}
