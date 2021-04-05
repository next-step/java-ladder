package step4_ladderGame.domain;

import java.util.List;

public interface CreatePointStrategy {
    boolean test(boolean lastPoint);

    List<Point> createPoint(int playerCount);
}
