package Ladder.application;

import Ladder.domain.DefaultLadderGenerator;
import Ladder.domain.LadderGame;
import Ladder.domain.LadderGenerator;

public class LadderController {
    public LadderGame start (final String[] inputNames, final int height) {
        final LadderGenerator ladderGenerator = new DefaultLadderGenerator();
        return LadderGame.of(inputNames, ladderGenerator.generate(inputNames.length, height));
    }
}
