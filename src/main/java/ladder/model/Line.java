package ladder.model;

import ladder.model.utils.ConnectLine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Boolean.FALSE;

public class Line implements LineInterface{
    private final List<Boolean> points;
    private final ConnectLine connectLine;

    public Line(List<Boolean> points, ConnectLine connectLine) {
        this.connectLine = connectLine;
        checkValidConnect(points);
        this.points = points;
    }

    public static Line createOneLine(int countOfPerson, ConnectLine connectLine) {
        List<Boolean> points = new ArrayList<>();
        int columnNum = countOfPerson - 1;

        boolean before = FALSE;
        while (points.size() < columnNum) {
            boolean next = connectLine(before, connectLine);
            points.add(next);
            before = next;
        }
        return new Line(points, connectLine);
    }


    public static boolean connectLine(boolean before, ConnectLine connectLine) {
        if (!before) {
            return connectLine.next();
        }
        return FALSE;
    }


    public void checkValidConnect(List<Boolean> points) {
        if (IntStream.range(0, points.size() - 1)
                .anyMatch(i -> points.get(i).equals(points.get(i + 1)) && points.get(i))) {
            throw new IllegalArgumentException("사다리는 연속으로 가로줄을 그릴수 없다.");
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
