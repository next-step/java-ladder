package laddergameplay.domain.ladder;

import laddergameplay.domain.dto.WinningResult;
import laddergameplay.domain.data.Person;
import laddergameplay.domain.data.Result;
import laddergameplay.domain.datas.People;
import laddergameplay.domain.datas.Results;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public WinningResult makeWinningResult(People people, Results results) {
        Map<Person, Result> winningResultMap = makePeopleResultsMap(people, results);

        return new WinningResult(winningResultMap);
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
