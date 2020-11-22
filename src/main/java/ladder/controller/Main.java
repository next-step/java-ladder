package ladder.controller;

import ladder.domain.model.Ladder;
import ladder.domain.model.Person;
import ladder.domain.model.Persons;
import ladder.domain.model.Results;
import ladder.dto.AllResultsDto;
import ladder.dto.LadderDto;
import ladder.view.ResponseView;

public class Main {

    public static void main(String[] args) {
        Persons persons = ModelMapper.getPersons();
        int sizeOfPersons = persons.size();
        Results results = ModelMapper.getValidatedResults(sizeOfPersons);
        Ladder ladder = ModelMapper.getLadder(sizeOfPersons);

        LadderDto ladderDto = new LadderDto(
                persons.exportPersonsDto(),
                results.exportResultsDto(),
                ladder.exportLinesDto()
        );
        ResponseView.printLadder(ladderDto);

        Person all = new Person("all");
        Person person = ModelMapper.getPerson();
        while (!person.equals(all)) {
            int movedPosition = ladder.move(
                    persons.getPosition(person)
            );
            ResponseView.printResult(
                    results.exportResultDto(movedPosition)
            );
            person = ModelMapper.getPerson();
        }

        ResponseView.printAllResults(new AllResultsDto(
                persons.exportPersonsDto(),
                results.exportMovedResultsDto(ladder::move)
        ));
    }
}
