package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Person;
import ladder.domain.Persons;
import ladder.domain.Results;
import ladder.dto.response.AllResultsDto;
import ladder.dto.response.LadderDto;
import ladder.view.ResponseView;

public class Main {

    public static void main(String[] args) {
        Persons persons = ModelMapper.getPersons();
        int sizeOfPersons = persons.getSize();
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
                    results.exportResult(movedPosition)
            );
            person = ModelMapper.getPerson();
        }

        ResponseView.printAllResults(new AllResultsDto(
                persons.exportPersonsDto(),
                results.exportMovedResultsDto(position -> ladder.move(position))
        ));
    }
}
