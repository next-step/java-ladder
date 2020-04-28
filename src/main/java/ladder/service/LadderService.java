package ladder.service;

import ladder.controller.response.ResultDto;
import ladder.domain.Person;
import ladder.service.type.GameResult;
import ladder.domain.Ladder;
import ladder.domain.Persons;
import ladder.view.exception.InvalidInputToGetResult;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class LadderService {
    public static final String GET_ALL_COMMENT = "꽝";

    public static ResultDto getAllResult(GameResult result) {
        return ResultDto.getAllResultInstance(result);
    }

    public static ResultDto getRequestedResult(GameResult result, String personToGetResult) {
        if (GET_ALL_COMMENT.equals(personToGetResult)) {
            return getAllResult(result);
        }

        if (!result.isContains(personToGetResult)) {
            throw new InvalidInputToGetResult();
        }

        return ResultDto.getInstance(personToGetResult, result.get(personToGetResult));
    }

    public static GameResult getLadderGameResult(Persons persons, Ladder ladder) {
        return persons.getResultOfLadder(ladder);
    }
}
