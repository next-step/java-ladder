package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Names;
import nextstep.ladder.domain.Prizes;
import nextstep.ladder.util.StringParser;

import static nextstep.ladder.ui.InputView.*;
import static nextstep.ladder.ui.OutputView.printLadder;
import static nextstep.ladder.ui.OutputView.printParticipants;

public class LadderCame {

    public static void main(String[] args) {
        Names participants = new Names(StringParser.split(personName()));
        Prizes prizes = new Prizes(StringParser.split(ladderPrize()));
        Height height = new Height(inputLadderHeight());
        Ladder ladder = new Ladder(height, participants.countOfParticipant());
        printParticipants(participants);
        printLadder(ladder);
    }

}
