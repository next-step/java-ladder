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

    public String getResultByName(String name) {
        int personIndex = matchUp.getPositionByName(name);
        return matchUp.getResultByPosition(ladder.move(personIndex));
    }

    public List<LadderLine> getLadder() {
        return new ArrayList<>(ladder.getLadderLines());
    }

    public List<Person> getPeople() {
        return new ArrayList<>(matchUp.getPeople());
    }

    public List<Result> getResults() {
        return new ArrayList<>(matchUp.getResults());
    }
}
