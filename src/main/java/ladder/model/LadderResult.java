package ladder.model;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private Map<Person, Reward> ladderResult = new HashMap<>();

    public void setResult(Person person, Reward reward) {
        ladderResult.put(person, reward);
    }

    public Reward getRewardByPerson(String person) {
        return ladderResult.get(Person.of(person));
    }
}

