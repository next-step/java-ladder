package laddergameplay.domain;

import laddergameplay.exception.CustomException;

import java.util.Collections;
import java.util.Map;

public class WinningResult {

    public static final String NOT_EXIST_EXCEPTION_MESSAGE = "참여하지 않은 사용자 입니다.";

    private final Map<Person, Result> winningResult;

    public WinningResult(Map<Person, Result> winningResult) {
        this.winningResult = winningResult;
    }

    public Result findBy(Person person) {
        validateNotExist(person);
        return winningResult.get(person);
    }

    private void validateNotExist(Person person) {
        if(!winningResult.containsKey(person)){
            throw new CustomException(NOT_EXIST_EXCEPTION_MESSAGE);
        }
    }

    public Map<Person, Result> findAll() {
        return Collections.unmodifiableMap(winningResult);
    }
}
