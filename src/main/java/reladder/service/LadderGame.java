package reladder.service;

import reladder.domain.*;

import java.util.*;

public class LadderGame {

    private Ladder ladder;
    private MatchUp matchUp;

    public LadderGame(Ladder ladder, MatchUp matchUp) {
        this.ladder = ladder;
        this.matchUp = matchUp;
    }

    public String getResult(String name) {
        int personIndex = matchUp.getPositionByName(name);
        return matchUp.getResultByPosition(ladder.move(personIndex));
    }

    public Map<String, Object> getResultAll() {
        Map<String, Object> result = new HashMap<>();
        for (Person person : matchUp.getPeople()) {
            int index = ladder.move(person.getPosition());
            result.put(person.getName(), matchUp.getResultByPosition(index));
        }
        return result;
    }

    public static boolean randomGenerate() {
        return new Random().nextBoolean();
    }

    public List<LadderLine> getLadder() {
        return new ArrayList<>(ladder.getLadderLines());
    }

    public List<Person> getPeople() {
        return new ArrayList<>(this.matchUp.getPeople());
    }

    public List<Result> getResults() {
        return new ArrayList<>(this.matchUp.getResults());
    }
}
