package ladder.step2.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameResultsDTO {
    private final List<String> playerNames;
    private final List<Integer> ladderPositionResult;
    
    public LadderGameResultsDTO(final PlayersDTO playersDTO, final List<Integer> ladderPositionResult) {
        this.playerNames = getPlayerNames(playersDTO);
        this.ladderPositionResult = ladderPositionResult;
    }
    
    private static List<String> getPlayerNames(final PlayersDTO playersDTO) {
        return playersDTO.getPlayerNameDTOS().stream()
                .map(PlayerNameDTO::getPlayerName)
                .collect(Collectors.toList());
    }
    
    public List<String> getPlayerNames() {
        return Collections.unmodifiableList(playerNames);
    }
    
    public List<Integer> getLadderPositionResult() {
        return Collections.unmodifiableList(ladderPositionResult);
    }
}
