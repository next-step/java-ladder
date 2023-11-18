package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private final Names names;
    private final Lines lines;

    public Ladder(Names names,
                  Lines lines) {
        this.names = names;
        this.lines = lines;
    }

    public Ladder(List<Name> names,
                  List<Line> lines) {
        this(new Names(names), new Lines(lines));
    }

    public Lines getLines() {
        return this.lines;
    }

    public Names getNames() {
        return this.names;
    }

    public int size() {
        return this.names.size();
    }

    public Name name(int point) {
        return this.names.name(point);
    }

    public int findEndPoint(int startPoint) {
        return this.lines.findEndPoint(startPoint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(names, ladder.names) && Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names, lines);
    }

}
