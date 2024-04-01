package nextstep.ladder.domain;
import nextstep.ladder.util.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line{

    private final List<Boolean> line;

    public Line(int size){
        this(generatePoints(size));
    }

    public Line(PointFactory pointFactory) {
        this(pointFactory.generatePoints());
    }

    public Line(List<Boolean> line) {
        this.line = line;
    }

    public static List<Boolean> generatePoints(int size) {
        ArrayList<Boolean> points = new ArrayList<>();
        for(int i =0; i < size-1; i++){
            points.add(RandomBooleanGenerator.generate());
        }
        return points;
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
