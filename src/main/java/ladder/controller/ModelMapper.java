package ladder.controller;

import ladder.domain.*;
import ladder.dto.PersonDto;
import ladder.dto.ResultDto;
import ladder.view.RequestView;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

class ModelMapper {
    private ModelMapper() {}

    static Person getPerson() {
        return new Person(RequestView.askPerson()
                .getName());
    }

    static Persons getPersons() {
        return RequestView.askPersons()
                .getPersons()
                .stream()
                .map(PersonDto::getName)
                .map(Person::new)
                .collect(collectingAndThen(toList(), Persons::new));
    }

    static Ladder getLadder(int sizeOfPersons) {
        return new Ladder(sizeOfPersons,
                RequestView.askLadderHeight()
                        .getHeight(),
                RandomDirectionStrategy.getInstance()
        );
    }

    static Results getValidatedResults(int sizeOfPersons) {
        return RequestView.askResults()
                .getResults()
                .stream()
                .map(ResultDto::getResult)
                .map(Result::new)
                .collect(collectingAndThen(toList(), results -> new ValidatedResults(sizeOfPersons, results)));
    }
}
