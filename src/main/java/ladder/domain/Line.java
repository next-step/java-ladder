package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final int PER_PERSON_LINE = 2;
    private static final int MIN_CHECKOUT_POINT = 1;
    private static final int PRE_CHECKOUT_POINT = 2;
    private List<LineType> lineTypes = new ArrayList<>();

    public Line(List<LineType> lineTypes) {
        this.lineTypes = lineTypes;
    }

    public Line(int participantCount, PossibilityStrategy possibilityStrategy) {
        IntStream.rangeClosed(0, (participantCount - 1) * PER_PERSON_LINE).forEach(point -> {
            lineTypes.add(LineType.makeType(new LineTypeDTO(point, possibilityStrategy, checkPrePoint(point))));
        });
    }

    public List<LineType> getLineTypes() {
        return lineTypes;
    }

    boolean checkPrePoint(int point) {
        if (point <= MIN_CHECKOUT_POINT) {
            return false;
        }
        return lineTypes.get(point - PRE_CHECKOUT_POINT).equals(LineType.HORIZONTAL);
    }
}
