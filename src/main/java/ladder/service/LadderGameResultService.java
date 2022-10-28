package ladder.service;

import ladder.domain.person.ResultPeople;
import ladder.domain.result.Result;
import ladder.domain.result.ResultMap;
import ladder.domain.result.Results;
import ladder.domain.ladder.ladderline.LadderLines;

public class LadderGameResultService {

    public ResultMap ladderGameResult(Results results, LadderLines ladderLines, ResultPeople resultPeople) {
        ResultMap resultMap = new ResultMap(resultPeople);
        resultPeople.resultPeople().forEach(person -> {
            Result result = results.result(ladderLines.result(person.number()));
            resultMap.setPersonResult(person, result);
        });
        return resultMap;
    }
}
