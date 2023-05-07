package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private static final int FIRST_INDEX = 0;

    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines drawLines(LadderInputs participants, DrawStrategy drawStrategy) {
        List<Line> lines = new ArrayList<>();
        boolean previous = false;

        for (int i = FIRST_INDEX; i < participants.countOfInputs(); i++) {
            boolean draw = drawStrategy.draw(i, previous);
            lines.add(new Line(draw));
            previous = draw;
        }

        return new Lines(lines);
    }

    public Results followLine() {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            results.add(resultPoint(i));
        }
        return new Results(results);
    }

    private Result resultPoint(int index) {
        int nextIndex = index + 1;
        if (nextIndex < lines.size() && lines.get(nextIndex).hasLine()) {
            return new Result(nextIndex);
        }

        if (lines.get(index).hasLine()){
            return new Result(index - 1);
        }

        return new Result(index);
    }

    public int numberOfLines() {
        return lines.size();
    }

    public List<Line> getLines() {
        return lines;
    }
}
