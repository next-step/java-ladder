package ladder;

import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

public class LadderPlayer {
    private final Persons persons;
    private final Results results;

    public LadderPlayer(Persons persons, Results results) {
        this.persons = persons;
        this.results = results;
    }

    public Map<Person, Result> getResultOf(String personName, Ladder ladder) {
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
