package ladder.domain.factory;

import ladder.domain.Position;

import java.util.List;

public interface ILine {

    Position nextPosition(Position position);

    List<Boolean> bridges();
}
