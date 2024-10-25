package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Person;

import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.view.InputView.inputLadderHeight;
import static nextstep.ladder.view.InputView.inputPeopleNames;
import static nextstep.ladder.view.ResultView.printLadder;

public class LadderGame {
    public static void main(String[] args) {
        List<Person> people = inputPeopleNames().stream()
                .map(name -> new Person(name))
                .collect(Collectors.toList());

        printLadder(people, new Ladder(inputLadderHeight(), people.size()));
    }
}
