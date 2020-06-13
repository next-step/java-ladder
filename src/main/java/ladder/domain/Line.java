package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

    List<Linetype> lineTypeList = new ArrayList<>();
    private static final int PER_PERSON_LINE = 2;
    private static final int CHUNKER_VALUE = 2;
    private static final int MIN_CHECKOUT_POINT = 1;
    private static final int PRE_CHECKOUT_POINT = 1;

    public Line() {

    }

    public Line(int participantCount) {
        IntStream.rangeClosed(0, (participantCount - 1) * PER_PERSON_LINE).forEach(point -> {
            lineTypeList.add(makeType(point));
        });
    }

    public Linetype makeType(int point) {
        if (point % CHUNKER_VALUE == 0) {
            return Linetype.VERTICAL;
        }
        return getRandomType(point);
    }

    public Linetype getRandomType(int point) {
        if (checkPrePoint(point)) {
            return Linetype.BLANK;
        }
        return getHorizontalType(new HalfPossibilityStrategy());
    }

    public Linetype getHorizontalType(PossibilityStrategy possibilityStrategy) {
        if (possibilityStrategy.check()) {
            return Linetype.HORIZONTAL;
        }
        return Linetype.BLANK;
    }

    private boolean checkPrePoint(int point) {
        if (point <= MIN_CHECKOUT_POINT) {
            return false;
        }
        return lineTypeList.get(point - PRE_CHECKOUT_POINT).equals(Linetype.HORIZONTAL);
    }

    public Line(List<Linetype> lineTypeList) {
        this.lineTypeList = lineTypeList;
    }

    public List<Linetype> getLineTypeList() {
        return lineTypeList;
    }
}
