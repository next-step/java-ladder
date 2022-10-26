package ladder;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderPlayer {
    private final Persons persons;
    private final Results results;
    private final Ladder ladder;

    public LadderPlayer(Persons persons, Results results, Ladder ladder) {
        this.persons = persons;
        this.results = results;
        this.ladder = ladder;
    }

    public Result getResultOf(Person person) {
        return results.findResultOf(persons.findResultOf(person, ladder));
    }

    public Map<Person, Result> getResultOfAll() {
        return persons.findAllFinalIndex(ladder)
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> results.findResultOf(e.getValue())));
    }
}
