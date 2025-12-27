package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.GenerateLadderLineStrategy;

import java.util.List;

public class Line {

    private List<Boolean> line;

    public Line(int row, GenerateLadderLineStrategy generate) {
        this.line = generate.generate(row);
    }

    public List<Boolean> getLine() {
        return line;
    }


}
