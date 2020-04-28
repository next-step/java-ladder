package ladder.service;

import ladder.controller.response.ResultDto;
import ladder.service.type.GameResult;
import ladder.domain.Ladder;
import ladder.domain.Persons;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderService {

    public static ResultDto getRequestedResult(GameResult result, String[] personsToGetResult) {
        return null;
    }

    public static GameResult getLadderGameResult(Persons persons, Ladder ladder) {
        return persons.getResultOfLadder(ladder);
    }
}
