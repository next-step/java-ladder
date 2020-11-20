package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Person;
import ladder.domain.Persons;
import ladder.view.RequestView;

import java.util.Random;
import java.util.stream.Collectors;

class ModelMapper {
    private static final Random random = new Random();

    private ModelMapper() {}

    static Persons getPersons() {
        return new Persons(RequestView.askPersons()
                .getPersons()
                .stream()
                .map(person -> new Person(person))
                .collect(Collectors.toList())
        );
    }

    static Ladder getLadder(int sizeOfPerson) {
        int height = RequestView.askLadderHeight()
                .getHeight();
        return new Ladder(
                height,
                () -> new Line(sizeOfPerson, () -> random.nextBoolean())
        );
    }
}
