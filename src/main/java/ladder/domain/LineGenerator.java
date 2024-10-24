package ladder.domain;

import java.util.List;

public interface LineGenerator {

    List<Boolean> generate(int numberOfPlayers);
}
