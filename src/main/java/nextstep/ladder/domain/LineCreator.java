package nextstep.ladder.domain;

import java.util.List;

public interface LineCreator {

    List<Line> createLine(int numberOfPlayers, PointFactory pointFactory);
}
