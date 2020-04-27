package ladder.controller.response;

import ladder.domain.Person;
import ladder.domain.ResultValue;

import java.util.HashMap;

public class GameResultDto {
    private HashMap<Person, ResultValue> gameResult;

    public ResultValue get(Person person) {
        return gameResult.get(person);
    }
}
