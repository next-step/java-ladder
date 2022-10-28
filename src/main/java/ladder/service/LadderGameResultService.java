package ladder.service;

import ladder.domain.person.ResultPeople;
import ladder.domain.result.ResultMap;
import ladder.dto.LadderGameResultDto;

public class LadderGameResultService {

    public ResultMap ladderGameResult(LadderGameResultDto ladderGameResultDto, ResultPeople resultPeople) {
        ResultMap resultMap = new ResultMap(resultPeople);
        resultMap.setResult(ladderGameResultDto);
        return resultMap;
    }
}
