package ladder.service;

import ladder.controller.response.ResultDto;
import ladder.service.type.GameResult;
import ladder.domain.Ladder;
import ladder.domain.Persons;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class LadderService {

    public static ResultDto getAllResult(GameResult result) {
        return ResultDto.getAllResultInstance(result);
    }

    public static ResultDto getRequestedResult(GameResult result, String personToGetResult) {
        return ResultDto.getInstance(personToGetResult, result.get(personToGetResult));
    }

    public static GameResult getLadderGameResult(Persons persons, Ladder ladder) {
        return persons.getResultOfLadder(ladder);
    }
}
