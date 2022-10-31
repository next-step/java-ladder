package ladder.service;

import ladder.domain.person.Person;
import ladder.domain.result.ResultMap;
import ladder.dto.LadderGameResultDto;

import java.util.List;

public class LadderGameResultService {

    public ResultMap ladderGameResult(LadderGameResultDto ladderGameResultDto, List<Person> searchPeopleNames) {
        return new ResultMap(ladderGameResultDto, searchPeopleNames);
    }
}
