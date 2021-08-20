package nextstep.ladders.controller;

import nextstep.ladders.domain.Ladder;
import nextstep.ladders.domain.Participants;

public class LadderController {

    public Participants register(final String participantsText) {
        return new Participants(participantsText);
    }

    public Ladder start(final int countOfPerson, final String maxLadderHeightText) {
        return new Ladder(countOfPerson, maxLadderHeightText);
    }
}
