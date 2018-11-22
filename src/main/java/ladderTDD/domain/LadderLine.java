package ladderTDD.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {

    private static final int START_POINT = 0;
    private static final int DEFAULT_ONE = 1;

    private List<Point> linePoints;

    private LadderLine(List<Point> linePoints) {
        this.linePoints = linePoints;
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        points.add(Point.first(new Random().nextBoolean()));

        for (int i = 1; i < sizeOfPerson-1; i++) {
            points.add(points.get(0).next(new Random().nextBoolean()));
        }

        points.add(Point.last(sizeOfPerson-1, new Random().nextBoolean()));

        return new LadderLine(points);
    }

    public int move(int position) {
        return this.linePoints.get(position).move();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = START_POINT; i < linePoints.size(); i++) {
            if (i != linePoints.size()-DEFAULT_ONE) {
                stringBuilder.append(linePoints.get(i).toString());
            }
        }
        return stringBuilder.toString();
    }
}
