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

        initPoints.add(LadderFactory.makeFirstPoint(ladderLine.getPoints().get(0).getIndex()));
        LadderFactory.makeBodyPoint(initPoints, ladderLine.getPoints().size());
        LadderFactory.makeLastPoint(initPoints);

        LadderFactory.swapIndex(initPoints, ladderLine.getPoints());

        return new LadderLine(initPoints);
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
