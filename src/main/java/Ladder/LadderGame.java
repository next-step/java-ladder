package Ladder;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LadderGame {
    private static final int INIT_HEIGHT=0;
    private Map<Person, Result> oneGameResult = new HashMap<>();
    private Lines lines;


    public LadderGame(Lines lines) {
        this.lines = lines;
    }

    public void calculateResult(Persons persons, Results results) {
        for (int i = 0; i < persons.personCount(); i++) {

            int resultPosition = this.calculateLadder(i, INIT_HEIGHT);
            oneGameResult.put(persons.getOnePerson(i), results.getOneResult(resultPosition));
        }
    }

    public int calculateLadder(int position, int height) {
        int resultPosition = position;
        while (height != lines.totalLineNum()) {
            resultPosition = lines.getOneLine(height).decideDestination(resultPosition);
            height++;
        }
        return resultPosition;
    }

    public Result getOneResult(Person person) {
        return oneGameResult.get(person);
    }

    public Set<Person> getKeySet() {
        return oneGameResult.keySet();
    }

}
