package ladder.model.result;

import ladder.model.player.PlayerName;
import ladder.model.player.Position;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class PositionResult {
    private Map<PlayerName, Position> positionResult;

    public PositionResult(Map<PlayerName, Position> positionResult) {
        this.positionResult = Collections.unmodifiableMap(positionResult);
    }

    public Map<PlayerName, Position> getPositionResult() {
        return positionResult;
    }

    public Set<PlayerName> getKeySet(){
        return positionResult.keySet();
    }

    public Position getPosition(PlayerName playerName){
        return positionResult.get(playerName);
    }

    public int getSize(){
        return positionResult.size();
    }
}
