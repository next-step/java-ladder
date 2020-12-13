package ladder.domain;

import java.util.Objects;

public class Ladder {

    private Line line;

    public Ladder(int ladderCount) {
       this.line = Line.init(ladderCount);
    }

    public Ladder(Line line){
        this.line = line;
    }

    public Line getLine() {
        return line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(line, ladder.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }

    public int move(int moveIndex) {
        return line.move(moveIndex);
    }
}
