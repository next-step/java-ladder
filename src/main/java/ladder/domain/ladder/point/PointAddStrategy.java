package ladder.domain.ladder.point;

import java.util.List;

public interface PointAddStrategy {
    List<PointEnum> makePoint(int countOfPerson);
}
