package ladder.service;

import ladder.controller.response.ResultDto;
import ladder.service.type.GameResult;
import ladder.domain.Ladder;
import ladder.domain.Persons;
import ladder.view.exception.InvalidInputToGetResult;

public class LadderService {
    private static final String GET_ALL_COMMENT = "all";

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
