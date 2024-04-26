package nextstep.ladder.interfaces;

import java.util.List;

public interface Ladder {
    LadderResult game();

    List<Line> getLines();
}
