package ladder.controller.response;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Person;
import ladder.domain.Persons;

import java.util.List;
import java.util.stream.Collectors;

public class LadderDto {
    private final List<String> personNames;
    private final List<Line> lines;
    private final List<String> ladderResult;

    private LadderDto(List<Person> personNames, Ladder ladder) {
        this.personNames = personNames.stream().map(Person::getNameOf).collect(Collectors.toList());
        this.lines = ladder.getLines();
        this.ladderResult = ladder.getLadderResult().getValues();
    }

    public static LadderDto getInstance(Persons persons, Ladder ladder) {
        return new LadderDto(persons.getPersons(), ladder);
    }

    public List<String> getPersonNames() {
        return this.personNames;
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public List<String> getLadderResult() {
        return this.ladderResult;
    }
}
