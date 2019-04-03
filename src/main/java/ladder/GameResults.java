package ladder;

import java.util.Map;
import java.util.stream.Collectors;

public class GameResults {
    private final Players players;
    private final Map<Player, EndPoint> result;

    public GameResults(Players players, EndPoints endPoints) {
        this.players = players;
        result = players.getPlayers()
                .stream()
                .collect(Collectors.toMap(player -> player, player -> endPoints.find(player.getDestination())));
    }

    public Map<Player, EndPoint> getResult() {
        return result;
    }

    public Players getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        result.entrySet().forEach(playerEndPointEntry ->
                sb.append(playerEndPointEntry.getKey().name)
                        .append(" : ")
                        .append(playerEndPointEntry.getValue().name)
                        .append("\n"));
        return sb.toString();
    }
}
