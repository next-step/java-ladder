package nextstep.ladders.controller;

import nextstep.ladders.domain.Ladder;
import nextstep.ladders.domain.strategy.DirectionRandomGenerate;

public class LadderController {

    public Ladder start(final String maxLadderHeightText, final String participantsText) {
        return new Ladder(new DirectionRandomGenerate(), maxLadderHeightText, participantsText);
    }
}