package nextstep.ladder.domain;

import java.util.List;

public interface Lines {
    void move(Position position);

    List<Boolean> getLines();
}
