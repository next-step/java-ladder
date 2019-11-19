package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lines;
    private MatchUp matchUp;

    public Ladder(LadderGenerator ladderGenerator, MatchUp matchUp) {
        this.lines = ladderGenerator.generate();
        this.matchUp = matchUp;
        matchPeopleToResult();
    }

    private void matchPeopleToResult() {
        this.matchUp.matchPeopleToResult(this.lines);
    }

    public String getResultValue(int position) {
        return this.matchUp.getResultValue(position);
    }

    public int getPersonPosition(String name) {
        return this.matchUp.getPersonPosition(name);
    }

    public List<Line> getLadderLines() {
        return new ArrayList<>(lines);
    }

    public List<Person> getPeople() {
        return matchUp.getPeople();
    }

    public List<Result> getResults() {
        return matchUp.getResults();
    }
}
