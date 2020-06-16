package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    public static final String POINT_TRUE = "-----|";
    public static final String POINT_FALSE = "     |";

    private List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line valueOf(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        Random random = new Random();
        boolean point = false;
        while (countOfPerson > 0 ){
            points.add(point);
            point = checkLineOverlap(point, random);
            countOfPerson --;
        }
        return new Line(points);
    }

    static boolean checkLineOverlap(Boolean point, Random random) {
        if (point) {
            return false;
        }
        return random.nextBoolean();
    }

    public String drawLadderLine() {
        String ladderLine = "";
        for (boolean point : points) {
            ladderLine += point ? POINT_TRUE : POINT_FALSE;
        }
        return ladderLine;
    }
}
