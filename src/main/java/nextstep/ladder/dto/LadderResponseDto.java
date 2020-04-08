package nextstep.ladder.dto;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.Results;

import java.util.List;

public class LadderResponseDto {
    private Ladder ladder;
    private List<Person> persons;
    private Results results;

    public LadderResponseDto(Ladder ladder, List<Person> persons, Results results) {
        this.ladder = ladder;
        this.persons = persons;
        this.results = results;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public List<Result> getResults() {
        return results.getResults();
    }
}
