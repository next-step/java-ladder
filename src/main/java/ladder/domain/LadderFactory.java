package ladder.domain;

import java.util.List;

public class LadderFactory {

    private LadderFactory() {
    }

    public static LadderPoint makeFirstPoint(final int index) {
        return new LadderPoint(index, LadderDirectionNext.makeDirectionFirst());
    }

    public static List<LadderPoint> makeBodyPoint(List<LadderPoint> initPoints , int countOfPerson) {
        LadderPoint point;

        for (int i = 1; i < countOfPerson - 1; i++) {
            point = LadderPoint.initPointBody(initPoints.get(i - 1));
            initPoints.add(point);
        }

        return initPoints;
    }

    public static List<LadderPoint> makeLastPoint(List<LadderPoint> initPoints) {
        initPoints.add(LadderPoint.initPointLast(initPoints.get(initPoints.size() - 1)));
        return initPoints;
    }

    public static void swapIndex(List<LadderPoint> initPoints, List<LadderPoint> paramList) {
        for (int i = 0; i < initPoints.size(); i++) {
            initPoints.get(i + initPoints.get(i).getDirection().moveDistance())
                    .movePoint(paramList.get(i).getIndex());
        }
    }
}
