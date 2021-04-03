package step4_ladderGame.domain;

import java.util.List;

public class LadderLine {

    private final List<Point> points;

    private LadderLine(List<Point> points, int playerCount) {
        if (points.size() != playerCount) {
            throw new IllegalArgumentException("사다리 라인 수와 플레이어 수가 맞지 않습니다.");
        }
        this.points = points;
    }

    public static LadderLine initLadderLine(int playerCount, CreatePointStrategy createStrategy) {
        return new LadderLine(createStrategy.createPoint(playerCount), playerCount);
    }

    public int size() {
        return points.size();
    }

}
