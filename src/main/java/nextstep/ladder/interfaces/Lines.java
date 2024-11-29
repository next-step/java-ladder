package nextstep.ladder.interfaces;

import java.util.List;

public interface Lines {
    void move(Position position);

    List<Boolean> getLines();
}
