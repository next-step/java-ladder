package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.util.StringParser;

import java.util.List;

public class LadderCame {

    public static void main(String[] args) {
        List<String> persons = StringParser.split(InputView.personName());
        Participants participatns = new Participants(persons);
        Height height = new Height(InputView.inputLadderHeight());
        Ladder ladder = new Ladder(height, participatns.countOfParticipant());
    }

}
