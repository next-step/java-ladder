package ladder.dto;

public class AllResultsDto {
    private final PersonsDto personsDto;
    private final ResultsDto resultsDto;

    public AllResultsDto(PersonsDto personsDto, ResultsDto resultsDto) {
        this.personsDto = personsDto;
        this.resultsDto = resultsDto;
    }

    public PersonsDto getPersonsDto() {
        return personsDto;
    }

    public ResultsDto getResultsDto() {
        return resultsDto;
    }
}
