package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final Lines lines = new Lines();
    private final int pointCount;

    public Ladder(int pointCount) {
        this.pointCount = pointCount;
    }

    public void makeLadder(int ladderHeight, LadderLineStrategy ladderLineStrategy) {
        for (int height = 0; height < ladderHeight; height++) {
            List<Boolean> pointList = makeLine(ladderLineStrategy);
            this.lines.addLine(new Line(pointList));
        }
    }

    public List<Boolean> makeLine(LadderLineStrategy ladderLineStrategy) {
        List<Boolean> pointList = new ArrayList<>();
        for (int userCount = 0; userCount < pointCount; userCount = pointList.size()) {
            pointList.add(ladderLineStrategy.boolLine());
            makePointList(pointList, pointCount - 1);
        }
        return pointList;
    }

    private void makePointList(List<Boolean> pointList, int userCount) {
        int currentIndex = pointList.size() - 1;
        if (pointList.get(currentIndex) && currentIndex < userCount) {
            pointList.add(true);
            ++currentIndex;
        }
        if (pointList.get(currentIndex) && currentIndex < userCount) {
            pointList.add(false);
            ++currentIndex;
        }
        if (currentIndex == userCount && !pointList.get(currentIndex - 1) && pointList.get(currentIndex)) {
            pointList.remove(currentIndex);
            pointList.add(false);
        }
    }

    public Lines getLines() {
        return this.lines;
    }

}
