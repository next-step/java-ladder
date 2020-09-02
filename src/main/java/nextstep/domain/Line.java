package nextstep.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {

    }

    public List<Boolean> getPoints() {
        return points;
    }

    public static List<Boolean> drawTransverseBar(int countOfPerson, TransverseBarStrategy transverseBarStrategy) {
        return transverseBarStrategy.draw(countOfPerson);
    }

}
