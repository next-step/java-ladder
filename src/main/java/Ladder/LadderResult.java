package Ladder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LadderResult {

    private Map<Person, Result> gameResult = new HashMap<>();

    public LadderResult(Map<Person, Result> gameResult) {
        this.gameResult.putAll(gameResult);
    }

    public String toString() {
        StringBuilder allResult = new StringBuilder();
        Iterator<Person> persons = gameResult.keySet().iterator();
        while (persons.hasNext()) {
            Person person = persons.next();
            allResult.append(person.toString()).append(" : ").append(gameResult.get(person).toString());
            allResult.append("\n");
        }
        return allResult.toString();
    }

    public Result oneResult(String person) throws Exception {
        return gameResult.get(new Person(person));
    }


}
