package nextstep.ladder.controller;

import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.util.StringParser;

import java.util.List;
import java.util.stream.Collectors;

public class LadderCame {

    public static void main(String[] args) {
        List<String> persons = StringParser.split(InputView.personName());
        Participants participatns = createParticipatns(persons);
        int ladderHeight = InputView.inputLadderHeight();
    }

    private static Participants createParticipatns(List<String> persons) {
        return new Participants(persons.stream()
                .map(Name::new)
                .collect(Collectors.toList()));
    }
}
