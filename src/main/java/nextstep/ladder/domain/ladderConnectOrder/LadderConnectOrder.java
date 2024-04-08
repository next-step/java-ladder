package nextstep.ladder.domain.ladderConnectOrder;

import java.util.List;
import nextstep.ladder.domain.line.Point;

@FunctionalInterface
public interface LadderConnectOrder {

    List<Point> connectLadder();

}
