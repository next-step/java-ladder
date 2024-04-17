package ladder.domain;

import java.util.List;

public interface LadderStrategy {
    List<Line> getLines();
    Position arrival(Position initialPosition);

}
