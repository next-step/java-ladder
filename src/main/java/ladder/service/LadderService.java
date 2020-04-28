package ladder.service;

import ladder.service.type.GameResult;
import ladder.domain.Ladder;
import ladder.domain.Persons;

public class LadderService {
    public static GameResult getLadderGameResult(Persons persons, Ladder ladder) {
        return persons.getResultOfLadder(ladder);
    }
}
