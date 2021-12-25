package nextstep.ladder.engine;

import java.util.List;

public interface ResultMap {
    void move(List<Line> lines);
    GameResult result(Players players);
}
