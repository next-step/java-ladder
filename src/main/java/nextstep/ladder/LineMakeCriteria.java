package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class LineMakeCriteria {

    private static final double HALF = 0.5;

    private final int countOfPerson;

    public LineMakeCriteria(int countOfPerson) {
        this.countOfPerson = countOfPerson;
    }

    public List<Boolean> makeables() {
        List<Boolean> makeables = new ArrayList<>();

        for (int i = 0; i < countOfPerson - 1; i++) {
            makeables.add(isMakeable());
        }
        return makeables;
    }

    private static boolean isMakeable() {
        return HALF < Math.random();
    }

}
