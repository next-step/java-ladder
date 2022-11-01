package ladder;

import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

public class LadderPlayer {
    private final Persons persons;
    private final Results results;
    private final Ladder ladder;

    public LadderPlayer(Persons persons, Results results, Ladder ladder) {
        this.persons = persons;
        this.results = results;
        this.ladder = ladder;
    }

    public Map<Person, Result> getResultOf(String personName) {
        Set<Map.Entry<Person, Integer>> entries = persons.findAllFinalIndex(ladder)
                .entrySet();
        if ("all".equals(personName)) {
            return entries.stream()
                    .collect(toMap(Map.Entry::getKey, e -> results.findResultOf(e.getValue())));
        }
        return entries.stream()
                .filter(e -> e.getKey().equals(new Person(personName)))
                .collect(toMap(Map.Entry::getKey, e -> results.findResultOf(e.getValue())));
    }

}
