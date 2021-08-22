package nextstep.ladders.controller;

import nextstep.ladders.domain.Ladder;
import nextstep.ladders.domain.RandomPointGenerateStrategy;

public class LadderController {

    public Ladder start(final String participantsText, final String executionResultText, final String maxLadderHeightText) {
        return new Ladder(new RandomPointGenerateStrategy(), participantsText, executionResultText, maxLadderHeightText);
    }
}
