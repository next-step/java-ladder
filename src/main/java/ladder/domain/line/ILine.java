package ladder.domain.line;

import ladder.domain.position.Position;

import java.util.List;

public interface ILine {

    Position nextPosition(Position position);

    List<Boolean> bridges();
}
