package reladder.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchUp {

    private static final int NOT_FOUND = -404;

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

    public String getResultValue(int position) {
        return this.results.getResultValue(position);
    }

    public Integer getPersonPosition(String name) {
        try {
            return this.people.getPersonPosition(name);
        } catch (IllegalArgumentException e) {
            return NOT_FOUND;
        }
    }

    public int getPeopleCount() {
        return this.people.size();
    }

    public int getResultCount() {
        return this.results.size();
    }

}
