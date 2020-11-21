package ladder.dto;

import java.util.List;

public class ResultsDto {
    private final List<ResultDto> results;

    public ResultsDto(List<ResultDto> results) {
        this.results = results;
    }

    public List<ResultDto> getResults() {
        return results;
    }
}
