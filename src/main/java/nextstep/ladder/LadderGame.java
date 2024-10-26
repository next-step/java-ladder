package nextstep.ladder;

import nextstep.ladder.domain.Person;

import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.domain.Ladder.createLadder;
import static nextstep.ladder.view.InputView.inputLadderHeight;
import static nextstep.ladder.view.InputView.inputPeopleNames;
import static nextstep.ladder.view.ResultView.printLadder;
import static nextstep.ladder.view.ResultView.printPeople;

public class LadderGame {
    public static void main(String[] args) {
        List<Person> people = inputPeopleNames().stream()
                .map(Person::new)
                .collect(Collectors.toList());
        int height = inputLadderHeight();

        printPeople(people);
        printLadder(createLadder(height, people.size()));
    }
}
