package ladder.domain.generator;

import ladder.domain.Stair;

import java.util.List;

public interface LineGenerator {
    List<Stair> generate(int playerCount);
}
