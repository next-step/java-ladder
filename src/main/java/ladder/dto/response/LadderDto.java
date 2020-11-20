package ladder.dto.response;

public class LadderDto {
    private final PersonsDto persons;
    private final LinesDto lines;

    public LadderDto(PersonsDto persons, LinesDto lines) {
        this.persons = persons;
        this.lines = lines;
    }

    public PersonsDto getPersons() {
        return persons;
    }

    public LinesDto getLines() {
        return lines;
    }
}
