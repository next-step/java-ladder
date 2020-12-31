package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {

    private List<LadderPoint> points = new ArrayList<>();
    private static Random random = new Random();

    public LadderLine(final int countOfPerson) {
        initLadderLine(countOfPerson);
    }

    public LadderLine(List<LadderPoint> points) {
        this.points = points;
    }

    public void initLadderLine(final int countOfPerson) {
        LadderPoint point = new LadderPoint(0, LadderDirectionNext.makeDirectionFirst());
        this.points.add(point);

        for (int i = 1; i < countOfPerson - 1; i++) {
            point = new LadderPoint(i, LadderDirectionNext.makeDirectionBody(points.get(i - 1).getDirection()));
            this.points.add(point);
        }

        point = new LadderPoint(countOfPerson - 1, LadderDirectionNext.makeDirectionLast(points.get(points.size() - 1).getDirection()));
        this.points.add(point);
    }

    public static LadderLine makeNextLine(LadderLine ladderLine) {
        List<LadderPoint> initPoints = new ArrayList<>();
        LadderPoint point = new LadderPoint(ladderLine.getPoints().get(0).getIndex(), LadderDirectionNext.makeDirectionFirst());
        initPoints.add(point);

        for (int i = 1; i < ladderLine.points.size() - 1; i++) {
            point = LadderPoint.movePointBody(initPoints.get(i - 1));
            initPoints.add(point);
        }

        point = LadderPoint.movePointLast(initPoints.get(initPoints.size() - 1));
        initPoints.add(point);

        swapIndex(initPoints, ladderLine.getPoints());

        return new LadderLine(initPoints);
    }

    private static void swapIndex(List<LadderPoint> initPoints, List<LadderPoint> paramList) {
        for (int i = 0; i < initPoints.size(); i++) {
            initPoints.get(i + initPoints.get(i).getDirection().moveDistance())
                    .movePoint(paramList.get(i).getIndex());
        }
    }

    public List<LadderPoint> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
