package ladder.service;

import ladder.domain.ResultMap;
import ladder.domain.Results;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.person.Person;

import java.util.List;

public class LadderGameResultService {

    public ResultMap ladderGameResult(Results results, LadderLines ladderLines, List<Person> resultPersons) {
        ResultMap resultMap = new ResultMap(resultPersons);
        resultPersons.forEach(person ->
                resultMap.setPersonResult(person, results.results.get(ladderLines.result(person.number()))));
        return resultMap;
    }
}
