package ladder.controller;

import ladder.domain.expert.*;
import ladder.domain.generator.DirectionGenerator;
import ladder.domain.generator.LadderGenerator;
import ladder.domain.generator.LineGenerator;
import ladder.dto.PersonDto;
import ladder.dto.ResultDto;
import ladder.strategy.RandomStrategy;
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
        // FIXME: Generator 의 중첩을 더 깔끔하게 할 방법은 없을까?
        return new LadderGenerator(
                RequestView.askLadderHeight()
                        .getHeight(),
                new LineGenerator(sizeOfPersons,
                        new DirectionGenerator(RandomStrategy.getInstance()))
        ).generate();
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
