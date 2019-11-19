package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchUp {

    private People people;
    private Results results;

    public MatchUp(String peopleName, String resultsName) {
        this.people = new People(peopleName);
        this.results = new Results(resultsName);
    }

    void matchPeopleToResult(List<Line> lines) {
        this.people.matchResult(lines);
    }

    String getResultValue(int position) {
        return this.results.getResultValue(position);
    }

    int getPersonPosition(String name) {
        return this.people.getPerson(name).getPosition();
    }

    List<Person> getPeople() {
        return new ArrayList<>(this.people.getPeople());
    }

    List<Result> getResults() {
        return new ArrayList<>(this.results.getResults());
    }

    public int getPeopleCount() {
        return this.people.size();
    }

    public int getResultCount() {
        return this.results.size();
    }

}
