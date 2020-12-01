package nextstep.ladder.util.pointsgenerator;

import java.util.List;

public interface PointsGenerator {
    List<Boolean> getPoints(int pointsSize);

    boolean generatePoint();
}
