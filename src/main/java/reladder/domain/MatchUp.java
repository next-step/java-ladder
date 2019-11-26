package reladder.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchUp {

    private People people;
    private Results results;

    public MatchUp(String peopleName, String resultsName) {
        this.people = new People(peopleName);
        this.results = new Results(resultsName);
        validate();
    }

    private void validate() {
        if (this.people.size() != results.size()) {
            throw new IllegalArgumentException("참여자 수 와 상품 수가 맞지 않습니다.");
        }
    }

    public String getResultByPosition(int position) {
        return this.results.getResultValue(position);
    }

    public List<Person> getPeople() {
        return new ArrayList<>(this.people.getPeople());
    }

    public List<Result> getResults() {
        return new ArrayList<>(this.results.getResults());
    }

    public Integer getPositionByName(String name) {
        return this.people.getPersonPosition(name);
    }

    public int getPeopleCount() {
        return this.people.size();
    }

    public int getResultCount() {
        return this.results.size();
    }

}
