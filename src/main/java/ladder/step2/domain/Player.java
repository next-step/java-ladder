package ladder.step2.domain;

import ladder.step2.dto.LadderResultDTO;
import ladder.step2.dto.LineDTO;

import java.util.List;
import java.util.Map;

public class Player {
    private final PlayerName playerName;
    private Position position;
    
    public Player(String input) {
        this(input, 0);
    }
    
    public Player(String playerName, int position) {
        this.playerName = new PlayerName(playerName);
        this.position = new Position(position);
    }
    
    public void putLadderGameResult(final Map<String, String> ladderGameResults, final List<LineDTO> lineDTOS, final List<LadderResultDTO> ladderResultsDTOS) {
        move(lineDTOS);
        
        final String playerName = this.playerName.getPlayerName();
        final LadderResultDTO ladderResultDTO = ladderResultsDTOS.get(position.getPosition());
        ladderGameResults.put(playerName, ladderResultDTO.getLadderResult());
    }
    
    private void move(final List<LineDTO> lineDTOS) {
        lineDTOS.stream()
                .map(LineDTO::getPartLines)
                .forEach(partLines -> this.position = position.move(partLines));
    }
    
    public PlayerName getPlayerName() {
        return playerName;
    }
    
    public Position getPosition() {
        return position;
    }
}
