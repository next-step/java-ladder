package ladder.service;

import ladder.controller.response.ResultDto;
import ladder.domain.*;
import ladder.service.type.GameResult;
import ladder.view.exception.InvalidInputToGetResult;

import java.util.List;

public class LadderService {
    private static final String GET_ALL_COMMENT = "all";

    public static ResultDto getRequestedResult(GameResult result, String personToGetResult) {
        if (GET_ALL_COMMENT.equals(personToGetResult)) {
            return getAllResult(result);
        }

        if (!result.isContains(personToGetResult)) {
            throw new InvalidInputToGetResult();
        }

        return ResultDto.getInstance(personToGetResult, result.get(personToGetResult));
    }

    private static ResultDto getAllResult(GameResult result) {
        return ResultDto.getAllResultInstance(result);
    }

    public static GameResult getLadderGameResult(Persons persons, Ladder ladder, Rewards rewards) {
        LadderMatchResult ladderMatchResult = ladder.play(persons.getCount());
        List<Person> personList = persons.getPersons();

        int countOfPerson = personList.size();
        GameResult gameResult = GameResult.getInstance();
        for (int i = 0; i < countOfPerson; i++) {
            int resultIndex = ladderMatchResult.get(i);
            gameResult.put(Person.nameOf(personList.get(i)), rewards.getValue(resultIndex));
        }

        return gameResult;
    }
}
