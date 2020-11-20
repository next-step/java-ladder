package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Person;
import ladder.domain.Persons;
import ladder.view.RequestView;

import java.util.Random;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

class ModelMapper {
    private static final Random random = new Random();

    private ModelMapper() {}

    static Persons getPersons() {
        return RequestView.askPersons()
                .getPersons()
                .stream()
                .map(Person::new)
                .collect(collectingAndThen(toList(), Persons::new));
    }

    static Ladder getLadder(int sizeOfPerson) {
        return new Ladder(RequestView.askLadderHeight()
                .getHeight(),
                () -> new Line(sizeOfPerson, () -> random.nextBoolean())
        );
    }
}
