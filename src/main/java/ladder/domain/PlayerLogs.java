package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerLogs {

    List<PlayerLog> playerLogs = new ArrayList<>();

    public PlayerLogs(List<PlayerLog> playerLogs) {
        this.playerLogs = playerLogs;
    }

    public int getPlayerLogsSize() {
        return playerLogs.size();
    }

    public Player getPlayerByPosition(Position position) {
        return playerLogs.stream()
                    .filter(playerLog -> playerLog.getPosition().equals(position))
                    .findFirst()
                    .map(PlayerLog::getPlayer)
                    .orElseThrow(IllegalArgumentException::new);
    }
}
