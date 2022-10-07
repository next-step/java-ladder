package ladder.step2.dto;

import ladder.step2.domain.Ladder;

import java.util.List;
import java.util.stream.Collectors;

public class LadderDTO {
    private final List<LineDTO> lineDTOS;
    
    public LadderDTO(Ladder ladder) {
        this.lineDTOS = parseLineDTOS(ladder);
    }
    
    private List<LineDTO> parseLineDTOS(final Ladder ladder) {
        return ladder.getLines().stream()
                .map(LineDTO::new)
                .collect(Collectors.toList());
    }
    
    public List<LineDTO> getLineDTOS() {
        return lineDTOS;
    }
}
