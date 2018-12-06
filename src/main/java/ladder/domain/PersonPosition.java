package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class PersonPosition {

    private Map<Person, Integer> personFinalPositions;

    private PersonPosition(People people, Ladder ladder) {
        personFinalPositions = new HashMap<>();
        for (int index = 0; index < people.size(); index++) {
            personFinalPositions.put(people.findPersonBy(index), ladder.progressGame(index));
        }
    }

    public static PersonPosition from(People people, Ladder ladder) {
        return new PersonPosition(people, ladder);
    }

    public Map<Person, Integer> getPersonFinalPositions() {
        return personFinalPositions;
    }

}
