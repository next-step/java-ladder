package Ladder;

import java.util.Iterator;
import java.util.Set;

public class LadderResult {
    private LadderGame ladderGame;
    private Set<Person> personSets;

    public LadderResult(LadderGame ladderGame) {
        this.ladderGame = ladderGame;
        this.personSets = ladderGame.getKeySet();
    }

    public String toString() {
        StringBuilder allResult = new StringBuilder();
        Iterator<Person> persons = personSets.iterator();
        while (persons.hasNext()) {
            Person person = persons.next();
            allResult.append(person.toString()).append(" : ").append(ladderGame.getOneResult(person).toString());
            allResult.append("\n");
        }
        return allResult.toString();
    }

    public Result oneResult(String person) throws Exception {
        return ladderGame.getOneResult(new Person(person));
    }
}
