package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class PersonPosition {

    private Map<Person, Position> personFinalPositions;

    private PersonPosition(People people, Ladder ladder) {
        personFinalPositions = new HashMap<>();
        for (int i = 0; i < people.size(); i++) {
            Position position = Position.from(i);
            ladder.progressGame(position);
            personFinalPositions.put(people.findPersonBy(i), position);
        }
    }

    public static PersonPosition from(People people, Ladder ladder) {
        return new PersonPosition(people, ladder);
    }

    public Map<Person, Position> getPersonFinalPositions() {
        return personFinalPositions;
    }

}
