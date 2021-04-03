package step4_ladderGame.domain;

import java.util.List;

public interface CreatePointStrategy {
    boolean test(boolean lastBoolean);

    List<Point> createPoint(int playerCount);
}
