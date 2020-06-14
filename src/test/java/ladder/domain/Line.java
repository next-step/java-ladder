package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    List<Linetype> lineTypes = new ArrayList<>();
    private static final int PER_PERSON_LINE = 2;
    private static final int CHUNKER_VALUE = 2;
    private static final int MIN_CHECKOUT_POINT = 1;
    private static final int PRE_CHECKOUT_POINT = 2;

    public Line() {
    }

    public Line(List<Linetype> lineTypes) {
        this.lineTypes = lineTypes;
    }

    public Line(int participantCount) {
        IntStream.rangeClosed(0, (participantCount - 1) * PER_PERSON_LINE).forEach(point -> {
            lineTypes.add(makeType(point));
        });
    }

    Linetype makeType(int point) {
        if (point % CHUNKER_VALUE == 0) {
            return Linetype.VERTICAL;
        }
        return getRandomType(point);
    }

    private Linetype getRandomType(int point) {
        if (checkPrePoint(point)) {
            return Linetype.BLANK;
        }
        return getHorizontalType(new HalfPossibilityStrategy());
    }

    Linetype getHorizontalType(PossibilityStrategy possibilityStrategy) {
        if (possibilityStrategy.check()) {
            return Linetype.HORIZONTAL;
        }
        return Linetype.BLANK;
    }

    private boolean checkPrePoint(int point) {
        if (point <= MIN_CHECKOUT_POINT) {
            return false;
        }
        return lineTypes.get(point - PRE_CHECKOUT_POINT).equals(Linetype.HORIZONTAL);
    }

    public List<Linetype> getLineTypes() {
        return lineTypes;
    }
}
