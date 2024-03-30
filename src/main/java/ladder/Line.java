package ladder;

import ladder.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        int columnNum = countOfPerson - 1;

        while (points.size() < columnNum) {
            checkLine();
        }
        if (points.size() > columnNum) {
            points.remove(points.size() - 1);
        }
    }

    private void checkLine() {
        if (1 == RandomGenerator.generate()) {
            points.add(TRUE);
        }
        points.add(FALSE);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
