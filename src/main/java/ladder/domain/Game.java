package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Person> persons;
    private final Ladder ladder;

    public Game(List<Person> personList, int ladderHeight) {
        if (ladderHeight < 2) {
            throw new IllegalArgumentException("사다리 높이는 1보다 커야 합니다.");
        }
        this.persons = personList;
        this.ladder = new Ladder(persons.size(), ladderHeight);
    }

    public String formattedNames() {
        return persons.stream()
                .map(Person::spaceAddedName)
                .reduce((n1, n2) -> n1 + n2)
                .get();
    }

    public ArrayList<Line> ladderLines() {
        return ladder.getLines();
    }
}
