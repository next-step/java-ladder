package nextstep.step4.api;

import java.util.List;

public interface Ladder {
    LadderResult play();

    List<Line> getLines();
}
