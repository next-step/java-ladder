package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private List<LadderPoint> points = new ArrayList<>();
    private List<Integer> positionList = new ArrayList<>();

    public LadderLine(final int countOfPerson) {
        initLine(countOfPerson);
        initPosition(countOfPerson);
    }

    public LadderLine(List<LadderPoint> points, List<Integer> positionList) {
        this.points = points;
        this.positionList = positionList;
    }

    private void initLine(final int countOfPerson) {
        LadderPoint point = new LadderPoint(false);
        this.points.add(point);

        for (int i = 1; i < countOfPerson - 1; i++) {
            point = new LadderPoint(points.get(points.size() - 1).isLadderPoint());
            points.add(point);
        }
    }

    private void initPosition(final int countOfPerson) {
        for (int i = 0; i < countOfPerson; i++) {
            this.positionList.add(i);
        }
    }

    public List<LadderPoint> getPoints() {
        return points;
    }

    public List<Integer> getPositionList() {
        return positionList;
    }
}