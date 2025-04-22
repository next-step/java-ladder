package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LadderLine {
    private final List<LadderPoint> ladderPoints;

    private LadderLine(List<LadderPoint> ladderPoints) {
       this.ladderPoints = ladderPoints;
    }

    public static LadderLine of(List<Boolean> crosses) {
        List<LadderPoint> points = new ArrayList<>();

        if (crosses.isEmpty()) {
            return new LadderLine(points);
        }
        points.add(LadderPoint.first(crosses.get(0)));
        for (int i = 1; i < crosses.size(); i++) {
            points.add(points.get(i - 1).next(crosses.get(i)));
        }
        points.add(points.get(points.size() - 1).last());

        return new LadderLine(points);
    }
    
    public static LadderLine genRandomLadderLine(int width, Random random) {
        List<LadderPoint> crossExist = new ArrayList<>();

        LadderPoint point = LadderPoint.first(random.nextBoolean());
        crossExist.add(point);
        for (int i = 1; i < width - 1; i++) {
            if (point.hasNotRightSide()) {
                point = point.next(random.nextBoolean());
            } else {
                point = point.next(false);
            }
            crossExist.add(point);
        }
        crossExist.add(point.last());

        return new LadderLine(crossExist);
    }

    public List<Boolean> crosses(){
        return ladderPoints.stream()
                .limit(ladderPoints.size() - 1) // 여기서 마지막 원소를 제외
                .map(LadderPoint::hasRightSide)
                .collect(Collectors.toList());
    }

    public int size() {
        return ladderPoints.size();
    }

    public LadderDirection getDirection(int width) {
        return ladderPoints.get(width).move();
    }

    public int getOffset(int width) {
        return ladderPoints.get(width).move().getOffset();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LadderLine ll = (LadderLine) o;
        return ladderPoints.equals(ll.ladderPoints);
    }

    @Override
    public int hashCode() {
        return ladderPoints.hashCode();
    }

}
