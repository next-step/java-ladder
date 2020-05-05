package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderMatchResult {
    private Map<Integer, Integer> matchResult;

    public LadderMatchResult() {
        this.matchResult = new HashMap<>();
    }

    public void put(int startIndex, int lastIndex) {
        matchResult.put(startIndex, lastIndex);
    }

    public GameResult map(Persons persons, Rewards rewards) {
        List<Person> personList = persons.getPersons();

        int countOfPerson = personList.size();
        GameResult gameResult = GameResult.getInstance();
        for (int i = 0; i < countOfPerson; i++) {
            int resultIndex = matchResult.get(i);
            gameResult.put(Person.nameOf(personList.get(i)), rewards.getValue(resultIndex));
        }

        return gameResult;
    }
}
