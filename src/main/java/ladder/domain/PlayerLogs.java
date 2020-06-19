package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerLogs {

    List<PlayerLog> playerLogs = new ArrayList<>();

    public PlayerLogs(List<PlayerLog> playerLogs) {
        this.playerLogs = playerLogs;
    }

    public static PlayerLogs of(List<PlayerLog> playerLogs) {
        return new PlayerLogs(playerLogs);
    }

    public int getPlayerLogsSize() {
        return playerLogs.size();
    }

    public String getPlayerNameByPositionIndex(int index) {
        return playerLogs.stream()
                    .filter(playerLog -> playerLog.getPosition() == index)
                    .findFirst()
                    .map(PlayerLog::getName)
                    .orElseThrow(IllegalArgumentException::new);
    }

}
