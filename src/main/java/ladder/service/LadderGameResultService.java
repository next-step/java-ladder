package ladder.service;

import ladder.domain.LadderTextInput;
import ladder.domain.person.People;
import ladder.domain.person.Person;
import ladder.domain.Result;
import ladder.domain.person.SearchPeopleNames;
import ladder.dto.LadderGameResultDto;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameResultService {

    public Result ladderGameResult(LadderGameResultDto ladderGameResultDto, List<Person> searchPeopleNames) {
        return new Result(ladderGameResultDto, searchPeopleNames);
    }

    public List<Person> resultPersonList(People people, SearchPeopleNames searchPeopleNames) {
        return people.findByName(searchPeopleNames.peopleNames().stream()
                .map(LadderTextInput::text)
                .collect(Collectors.toList()));
    }
}
