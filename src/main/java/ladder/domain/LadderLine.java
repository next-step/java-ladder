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

    public LadderLine(final LadderLine ladderLine) {
        initLadderLine(ladderLine);
    }

    public void initLadderLine(final int countOfPerson) {
        initStartOrLast(0, new LadderDirection(false, random.nextBoolean()));
        initFirstBody(countOfPerson);

        if (countOfPerson > 2) {
            initStartOrLast(points.size(),
                    new LadderDirection(this.points.get(points.size() - 1).getDirection().isRight(), false));
        }
    }

    public void initLadderLine(final LadderLine ladderLine) {
        firstAdd(ladderLine);
        bodyAdd(ladderLine);
        lastAdd(ladderLine);
    }

    private void firstAdd(final LadderLine ladderLine) {
        LadderDirection direction = new LadderDirection(false, random.nextBoolean());
        int index = 0;

        if (direction.isRight()) {
            index = 1;
        }
        LadderPoint ladderPoint = new LadderPoint(ladderLine.getPoints().get(index).getIndex(), direction);

        points.add(ladderPoint);
    }


    private void lastAdd(final LadderLine ladderLine) {
        LadderDirection direction = new LadderDirection(points.get(points.size() - 1).getDirection().isRight(), false);

        int index = ladderLine.getPoints().size() - 1;

        if (direction.isLeft()) {
            index = index - 1;
        }

        LadderPoint ladderPoint = new LadderPoint(ladderLine.getPoints().get(index).getIndex(), direction);
        points.add(ladderPoint);
    }

    public void bodyAdd(final LadderLine ladderLine) {
        for (int i = 1; i < ladderLine.getPoints().size() - 1; i++) {
            LadderDirection direction = checkDirection(points.get(i - 1).getDirection());
            LadderPoint ladderPoint = new LadderPoint(ladderLine.getPoints().get(i).getIndex(), direction);
            chageAdd(ladderPoint, i, ladderLine);
        }
    }

    private void chageAdd(LadderPoint ladderPoint, int paramIndex, LadderLine ladderLine) {
        int index = paramIndex + ladderPoint.getMoveIndex();
        LadderPoint point = new LadderPoint(ladderLine.getPoints().get(index).getIndex(), ladderPoint.getDirection());
        this.points.add(point);
    }

    private void initStartOrLast(final int index, final LadderDirection direction) {
        LadderPoint point = new LadderPoint(index, direction);
        point.move();
        this.points.add(point);
    }

    private void initFirstBody(final int countOfPerson) {
        LadderPoint point;

        for (int i = 1; i < countOfPerson - 1; i++) {
            point = new LadderPoint(i, checkDirection(points.get(i - 1).getDirection()));
            point.move();
            this.points.add(point);
        }
    }

    private LadderDirection checkDirection(LadderDirection beforePoint) {
        boolean left;
        boolean right;

        if (beforePoint.isRight()) {
            return new LadderDirection(true, false);
        }

        return new LadderDirection(false, random.nextBoolean());
    }

    public List<LadderPoint> getPoints() {
        return points;
    }
}
