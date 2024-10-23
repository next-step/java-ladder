package laddergame.v2.domain.generator;

import laddergame.v2.domain.LadderPlayResult;
import laddergame.v2.domain.Players;

import java.util.List;

public interface PlayResultGenerator {
    LadderPlayResult generate(Players players, List<Integer> finalPositions);
}
