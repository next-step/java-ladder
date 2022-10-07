package ladder.step2.domain;

import ladder.step2.dto.LadderResultDTO;
import ladder.step2.dto.LineDTO;

import java.util.HashMap;
import java.util.List;

public class Player {
    private static final String PLAYER_NAME_LENGTH_EXCEPTION_MESSAGE = "플레이어 이름은 5자를 초과할 수 없습니다.";
    private static final int PLAYER_NAME_MAX_LENGTH = 5;
    
    private final PlayerName playerName;
    private Position position;
    
    public Player(String input) {
        this(input, 0);
    }
    
    public Player(String playerName, int position) {
        if (playerName.length() > PLAYER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(PLAYER_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
        
        this.playerName = new PlayerName(playerName);
        this.position = new Position(position);
    }
    
    public PlayerName getPlayerName() {
        return playerName;
    }
    
    public Position getPosition() {
        return position;
    }
    
    public void putLadderGameResult(final HashMap<String, String> ladderGameResults, final List<LineDTO> lineDTOS, final List<LadderResultDTO> ladderResultsDTOS) {
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
}
