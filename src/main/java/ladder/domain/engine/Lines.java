package ladder.domain.engine;

import java.util.List;

public interface Lines {
    List<Line> getLines();

    Players move(Players players);
}
