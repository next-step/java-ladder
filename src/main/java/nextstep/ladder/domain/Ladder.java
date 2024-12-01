package nextstep.ladder.domain;

import java.util.List;

public interface Ladder {
    List<Lines> getLines();

    Position result();
}
