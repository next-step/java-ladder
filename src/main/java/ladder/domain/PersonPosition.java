package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class PersonPosition {

    private Map<Person, Position> personPositions;

    private PersonPosition(People people) {
        personPositions = new HashMap<>();
        for (int i = 0; i < people.size(); i++) {
            personPositions.put(people.findPersonBy(i), Position.from(i));
        }
    }

    public static PersonPosition from(People people) {
        return new PersonPosition(people);
    }

    public Map<Person, Position> getPersonPositions() {
        return personPositions;
    }

    public void calculateFinalPosition(Ladder ladder){
        for (Person person : personPositions.keySet()) {
            Position position = ladder.calculatePosition(personPositions.get(person));
            personPositions.put(person, position);
        }
    }

    public Position findPersonPosition(Person person){
        return personPositions.get(person);
    }

    @Override
    public String toString() {
        return "PersonPosition{" +
                "personPositions=" + personPositions +
                '}';
    }
}
