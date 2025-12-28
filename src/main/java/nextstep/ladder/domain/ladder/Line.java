package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.GenerateLadderLineStrategy;

import java.util.List;

public class Line {

    private List<Boolean> line;

    public Line(int row, GenerateLadderLineStrategy generate) {
        this.line = generate.generate(row);
    }

    public int size(){
        return this.line.size();
    }

    public List<Boolean> getLine() {
        return line;
    }

    @Override
    public String toString() {
        return "Line{" +
                "line=" + line +
                '}';
    }
}
