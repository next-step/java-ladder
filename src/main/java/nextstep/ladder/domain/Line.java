package nextstep.ladder.domain;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Boolean> line;


    public Line(){
        this(new ArrayList<>());
    }

    public Line(PointFactory pointFactory) {
        this(pointFactory.generatePoints());
    }

    public Line(List<Boolean> line) {
        this.line = line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line1 = (Line) o;
        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }

    public List<Boolean> getLine() {
        return line;
    }
}
