package ladder.service;

import ladder.domain.result.Result;
import ladder.domain.result.ResultMap;
import ladder.domain.result.Results;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.person.Person;

import java.util.List;

public class LadderGameResultService {

    public ResultMap ladderGameResult(Results results, LadderLines ladderLines, List<Person> resultPersons) {
        ResultMap resultMap = new ResultMap(resultPersons);
        resultPersons.forEach(person -> {
            Result result = results.result(ladderLines.result(person.number()));
            resultMap.setPersonResult(person, result);
        });
        return resultMap;
    }
}
