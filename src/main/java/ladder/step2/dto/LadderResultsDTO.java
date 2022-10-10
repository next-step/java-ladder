package ladder.step2.dto;

import ladder.step2.domain.LadderResults;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResultsDTO {
    private final List<LadderResultDTO> ladderResultsDTOS;
    
    public LadderResultsDTO(final LadderResults ladderResults) {
        this.ladderResultsDTOS = parseLadderResultDTOS(ladderResults);
    }
    
    private List<LadderResultDTO> parseLadderResultDTOS(final LadderResults ladderResults) {
        return ladderResults.getLadderResults().stream()
                .map(LadderResultDTO::new)
                .collect(Collectors.toList());
    }
    
    public List<LadderResultDTO> getLadderResultsDTOS() {
        return ladderResultsDTOS;
    }
}
