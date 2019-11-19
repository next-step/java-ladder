package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchUp {

    private static final int ERROR_POSITION = -1;

    private People people;
    private Results results;

    public MatchUp(String peopleName, String resultsName) {
        this.people = new People(peopleName);
        this.results = new Results(resultsName);
        validate();
    }

    private void validate() {
        if (this.people.size() != results.size()) {
            throw new IllegalArgumentException();
        }
    }

    void matchPeopleToResult(List<Line> lines) {
        this.people.matchResult(lines);
    }

    String getResultValue(int position) {
        return this.results.getResultValue(position);
    }

    int getPersonPosition(String name) {
        try {
            return this.people.getPerson(name).getPosition();
        } catch (IllegalArgumentException e) {
            return ERROR_POSITION;
        }
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
