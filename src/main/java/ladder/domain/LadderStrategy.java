package ladder.domain;

import java.util.List;

public interface LadderStrategy {
    List<LineStrategy> getLines();
    Position arrival(Position initialPosition);

}
