package laddergame.v2.domain.generator;

import laddergame.v2.domain.Ladder;

public interface LadderGenerator {
    Ladder generate(int playerCount, int height);
}
