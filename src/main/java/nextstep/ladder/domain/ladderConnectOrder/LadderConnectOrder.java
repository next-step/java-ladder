package nextstep.ladder.domain.ladderConnectOrder;

import java.util.List;
import nextstep.ladder.domain.lines.Point;

@FunctionalInterface
public interface LadderConnectOrder {

    List<Point> connectLadder();

}
