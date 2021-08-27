package laddergameplay.domain;

import laddergame.exception.CustomException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public WinningResult makeWinningResult(People people, Results results) {
        validateCountOfResults(people, results);

        Map<Person, Result> winningResultMap = makePeopleResultsMap(people, results);

        return new WinningResult(winningResultMap);
    }

    private void validateCountOfResults(People people, Results results) {
        if (results.getResults().size() != people.getPeople().size()) {
            throw new CustomException("실행 결과의 개수를 잘못 입력 하였습니다.");
        }
    }

    private Map<Person, Result> makePeopleResultsMap(People people, Results results) {
        List<Integer> winningResultList = ladder.result();

        return arrangeValues(people, results, winningResultList);
    }

    private Map<Person, Result> arrangeValues(People people, Results results, List<Integer> winningResultList) {
        Map<Person, Result> winningResultMap = new LinkedHashMap<>();

        for (int i = 0; i < winningResultList.size(); i++) {
            Person person = people.getPeople().get(i);
            Result result = results.getResults().get(winningResultList.get(i));
            winningResultMap.put(person, result);
        }

        return winningResultMap;
    }
}
