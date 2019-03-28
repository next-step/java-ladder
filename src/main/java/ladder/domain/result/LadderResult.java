package ladder.domain.result;

import ladder.domain.players.Person;
import ladder.domain.rewards.Item;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {
    private Map<Person, Item> results;

    LadderResult() {
        results = new LinkedHashMap<>();
    }

    void addResult(Person person, Item item) {
        results.put(person, item);
    }

    public Item getItemByPersonName(String personName) {
        return this.results.get(new Person(personName));
    }

    public Map<Person, Item> getResults() {
        return Collections.unmodifiableMap(results);
    }
}
