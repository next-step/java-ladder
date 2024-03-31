package ladder.model;

import ladder.model.utils.ConnectLine;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Line {
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line createOneLine(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        int columnNum = countOfPerson - 1;

        while (points.size() < columnNum) {
            connectLine(points);
        }
        if (points.size() > columnNum) {
            points.remove(points.size() - 1);
        }
        return new Line(points);
    }

    private static void connectLine(List<Boolean> points) {
        if (ConnectLine.isConnect()) {
            points.add(TRUE);
        }
        points.add(FALSE);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
