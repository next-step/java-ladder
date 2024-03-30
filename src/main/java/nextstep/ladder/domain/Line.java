package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Boolean> line;

    public Line(Participant participant, PointGenerator pointGenerator) {
        this(generateByGenerator(participant, pointGenerator));
    }

    public Line(List<Boolean> line) {
        this.line = line;
    }

    private static List<Boolean> generateByGenerator(Participant participant, PointGenerator pointGenerator){
        ArrayList<Boolean> result = new ArrayList<>();
        for(int i =0; i < participant.getSize(); i++){
            result.add(pointGenerator.generate());
        }
        return result;
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
}
