package nextstep.ladder.domain;

import java.util.List;

public class LadderGameInfo {
    private List<Person> persons;
    private List<Result> results;

    public LadderGameInfo(List<Person> persons, List<Result> results) {
        validateSize(persons, results);
        this.persons = persons;
        this.results = results;
    }

    private void validateSize(List<Person> persons, List<Result> results) {
        if (persons.size() != results.size()) {
            throw new IllegalArgumentException("실행 결과는 인원수와 동일해야 합니다.");
        }
    }

    public List<Person> getPersons() {
        return persons;
    }

    public List<Result> getResults() {
        return results;
    }
}
