package ladder.service;

import ladder.domain.person.Person;
import ladder.domain.Result;
import ladder.dto.LadderGameResultDto;

import java.util.List;

public class LadderGameResultService {

    public Result ladderGameResult(LadderGameResultDto ladderGameResultDto, List<Person> searchPeopleNames) {
        return new Result(ladderGameResultDto, searchPeopleNames);
    }
}
