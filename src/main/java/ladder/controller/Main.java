package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Persons;
import ladder.domain.Results;
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

//        for (; ; ) {
//            Person person = ModelMapper.getPerson();
//
//        }
    }
}
