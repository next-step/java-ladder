package ladder.model;

import java.util.List;

public interface MoveStrategy {

    List<Boolean> generate(int size);
}
