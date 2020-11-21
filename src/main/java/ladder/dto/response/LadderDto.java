package ladder.dto.response;

import ladder.dto.PersonsDto;
import ladder.dto.ResultsDto;

public class LadderDto {
    private final PersonsDto persons;
    private final ResultsDto results;
    private final LinesDto lines;

    public LadderDto(PersonsDto persons, ResultsDto results, LinesDto lines) {
        this.persons = persons;
        this.results = results;
        this.lines = lines;
    }

    public PersonsDto getPersons() {
        return persons;
    }

    public ResultsDto getResults() {
        return results;
    }

    public LinesDto getLines() {
        return lines;
    }
}
