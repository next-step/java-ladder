package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Game {

    private final PersonList persons;
    private final Ladder ladder;

    public Game(PersonList personList, int ladderHeight) {
        this.persons = personList;
        this.ladder = new Ladder(persons.listSize(), ladderHeight);
    }

    public Game(PersonList personList, List<LineCondition> conditions) {
        this.persons = personList;
        this.ladder = new Ladder(persons.listSize(), conditions);
    }

    public String formattedNames() {
        return persons.getPersonList().stream()
                .map(Person::spaceAddedName)
                .reduce((n1, n2) -> n1 + n2)
                .get();
    }

    public List<Line> ladderLines() {
        return Collections.unmodifiableList(ladder.getLines());
    }

    public void playGame() {
        persons.movePersons(ladder);
    }

    public PersonList getPersons() {
        return persons;
    }
}
