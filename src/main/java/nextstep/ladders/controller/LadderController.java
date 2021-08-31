package nextstep.ladders.controller;

import nextstep.ladders.Ladder;
import nextstep.ladders.RandomGenerateStrategy;

public class LadderController {

    public Ladder start(final String maxLadderHeightText, final String participantsText) {
        return new Ladder(new RandomGenerateStrategy(), maxLadderHeightText, participantsText);
    }
}