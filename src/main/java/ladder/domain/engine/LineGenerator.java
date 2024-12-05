package ladder.domain.engine;

import java.util.List;

public interface LineGenerator {

    List<Boolean> generate(int numberOfPlayers);
}
