package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Person;
import ladder.domain.Persons;
import ladder.view.RequestView;

import java.util.stream.Collectors;

class ModelMapper {
    private ModelMapper() {}

    static Persons getPersons() {
        return new Persons(RequestView.askPersons()
                .getPersons()
                .stream()
                .map(person -> new Person(person))
                .collect(Collectors.toList())
        );
    }

    static Ladder getLadder() {
        return new Ladder(RequestView.askLadderHeight()
                .getHeight()
        );
    }
}
