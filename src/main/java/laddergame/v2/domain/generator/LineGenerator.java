package laddergame.v2.domain.generator;

import laddergame.v2.domain.Line;

public interface LineGenerator {
    Line generate(int playerCount);
}
