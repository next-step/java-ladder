package ladder.dto.response;

import ladder.dto.PersonDto;
import ladder.dto.ResultDto;

import java.util.Map;

public class AllResultsDto {
    private final Map<PersonDto, ResultDto> allResults;

    public AllResultsDto(Map<PersonDto, ResultDto> allResults) {
        this.allResults = allResults;
    }

    public Map<PersonDto, ResultDto> getAllResults() {
        return allResults;
    }

}
