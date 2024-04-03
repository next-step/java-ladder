package ladder.model;

import ladder.model.utils.ConnectLine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        checkValidConnect(points);
        this.points = points;
    }

    public static Line createOneLine(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        int columnNum = countOfPerson - 1;

        boolean before = FALSE;
        while (points.size() < columnNum) {
            boolean next = connectLine(before);
            points.add(next);
            before = next;
        }
        return new Line(points);
    }

    private static boolean connectLine(boolean before) {
        if(!before){
            return ConnectLine.next();
        }
        return FALSE;
    }

    private void checkValidConnect(List<Boolean> points){
        if (IntStream.range(0, points.size() - 1)
                .anyMatch(i -> points.get(i).equals(points.get(i + 1)) && points.get(i))) {
            throw new IllegalArgumentException("사다리는 연속으로 가로줄을 그릴수 없다.");
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
