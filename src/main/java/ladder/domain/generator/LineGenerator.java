package ladder.domain.generator;

import java.util.List;

public interface LineGenerator {
    List<Boolean> generate(int playerCount);
}
