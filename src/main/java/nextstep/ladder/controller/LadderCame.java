package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Names;
import nextstep.ladder.domain.Prizes;
import nextstep.ladder.util.StringParser;

import static nextstep.ladder.ui.InputView.*;
import static nextstep.ladder.ui.OutputView.*;

public class LadderCame {

    public static void main(String[] args) {
        Names participants = new Names(StringParser.split(personName()));
        Prizes prizes = new Prizes(StringParser.split(ladderPrize()));
        Height height = new Height(inputLadderHeight());
        Ladder ladder = new Ladder(height, participants.countOfParticipant());
        for (int position = 0; position < participants.countOfParticipant(); position++) {
            int resultPosition = ladder.climb(position);
        }
        printParticipants(participants);
        printLadder(ladder);
        printPrizes(prizes);
    }

}
