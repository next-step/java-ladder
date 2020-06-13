package ladder.domain;

import java.util.Objects;

public class ResultOfPlayer {
    private final String playerName;
    private final String result;

    public ResultOfPlayer(String playerName, String result) {
        this.playerName = playerName;
        this.result = result;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultOfPlayer that = (ResultOfPlayer) o;
        return Objects.equals(playerName,that.playerName) &&
                Objects.equals(result,that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName,result);
    }
}
