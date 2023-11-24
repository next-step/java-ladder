package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.util.StringParser;

import java.util.List;

import static nextstep.ladder.ui.InputView.inputLadderHeight;
import static nextstep.ladder.ui.InputView.personName;
import static nextstep.ladder.ui.OutputView.printLadder;
import static nextstep.ladder.ui.OutputView.printParticipants;

public class LadderCame {

    public static void main(String[] args) {
        List<String> persons = StringParser.split(personName());
        Participants participatns = new Participants(persons);
        Height height = new Height(inputLadderHeight());
        Ladder ladder = new Ladder(height, participatns.countOfParticipant());
        printParticipants(participatns);
        printLadder(ladder);
    }

}
