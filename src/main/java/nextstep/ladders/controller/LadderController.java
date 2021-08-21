package nextstep.ladders.controller;

import nextstep.ladders.domain.Ladder;
import nextstep.ladders.domain.LadderInfo;
import nextstep.ladders.domain.RandomPointGenerateStrategy;

public class LadderController {

    public LadderInfo register(final String participantsText, final String executionResultText) {
        return new LadderInfo(participantsText, executionResultText);
    }

    public Ladder start(final int countOfPerson, final String maxLadderHeightText) {
        return new Ladder(new RandomPointGenerateStrategy(), countOfPerson, maxLadderHeightText);
    }
}
