package ladderrefactoring.domain.ladder;

import ladderrefactoring.domain.data.Person;
import ladderrefactoring.domain.data.Result;
import ladderrefactoring.domain.datas.People;
import ladderrefactoring.domain.datas.Results;
import ladderrefactoring.exception.CustomException;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    public static final String NOT_EXIST_EXCEPTION_MESSAGE = "참여하지 않은 사용자 입니다.";

    private final Map<Person, Result> winningResult;

    public WinningResult(Ladder ladder, People people, Results results) {
        this.winningResult = makePeopleResultsMap(ladder, people, results);
    }

    private Map<Person, Result> makePeopleResultsMap(Ladder ladder, People people, Results results) {
        List<Integer> winningResultList = ladder.result();

        return arrangeValues(people, results, winningResultList);
    }

    private Map<Person, Result> arrangeValues(People people, Results results, List<Integer> winningResultList) {
        Map<Person, Result> winningResultMap = new LinkedHashMap<>();

        for (int i = 0; i < winningResultList.size(); i++) {
            Person person = people.people().get(i);
            Result result = results.results().get(winningResultList.get(i));
            winningResultMap.put(person, result);
        }

        return winningResultMap;
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
