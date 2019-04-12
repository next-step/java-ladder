package ladder.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
public class PlayResult {
    private Player player;
    private GameResult gameResult;

    public PlayResult(Player player, GameResult gameResult) {
        this.player = player;
        this.gameResult = gameResult;
    }

    public boolean isEqualsName(String userName) {
        return player.isEqualsName(userName);
    }

    public boolean isEqualsPlayer(Player searchPlayer) {
        return player.isEquals(searchPlayer);
    }

    public String getName() {
        return player.getName();
    }

    public String getGameResult() {
        return gameResult.getGameResult();
    }
}
