package ladderTDD.domain;

import ladder.utils.GenerateRandomUtil;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {

    private static final int START_POINT = 0;
    private static final int DEFAULT_ONE = 1;

    private List<Point> linePoints;

    private LadderLine(List<Point> linePoints) {
        this.linePoints = linePoints;
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        points.add(Point.first(GenerateRandomUtil.generateRandomBoolean()));

        for (int i = DEFAULT_ONE; i < sizeOfPerson-DEFAULT_ONE; i++) {
            points.add(points.get(i-DEFAULT_ONE).next());
        }

        points.add(points.get(points.size()-DEFAULT_ONE).last(sizeOfPerson-DEFAULT_ONE));

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
