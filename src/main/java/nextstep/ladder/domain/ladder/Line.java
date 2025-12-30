package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.GenerateLadderLineStrategy;

import java.util.List;

public class Line {

    private List<Boolean> lines;

    public Line(int row, GenerateLadderLineStrategy generate) {
        this.lines = generate.generate(row);
    }

    public int size() {
        return this.lines.size();
    }

    public List<Boolean> getLines() {
        return lines;
    }

    public int move(int position) {
        if (isMoveRight(position)) {
            return ++position;
        }

        if (isMoveLeft(position)) {
            return --position;
        }

        return position;
    }

    private boolean isMoveRight(int position) {
        return position < lines.size() && lines.get(position);
    }

    public boolean isMoveLeft(int position) {
        return position > 0 && lines.get(position - 1);
    }

    @Override
    public String toString() {
        return "Line{" +
                "line=" + lines +
                '}';
    }

}
