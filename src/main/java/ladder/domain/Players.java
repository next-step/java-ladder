package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    public final static String PLAYER_DELIMITER = ",";

    List<Player> players = new ArrayList<>();

    public Players(String players) {
        String[] playerArray = players.split(PLAYER_DELIMITER);
        this.players = IntStream.range(0, playerArray.length)
                .mapToObj(i -> new Player(playerArray[i], i))
                .collect(Collectors.toList());
    }

    public int getPlayerCount() {
        return players.size();
    }

    public List<String> getPlayerName() {
        return players.stream()
                    .map(p -> p.getName())
                    .collect(Collectors.toList());
    }

    public List<PlayerLog> getPlayerLogs() {
        return players.stream()
                    .map(player -> new PlayerLog(player.getName(), player.getPosition().getIndex()))
                    .collect(Collectors.toList());
    }

    public void move(Line line) {
        boolean beforeDraw = false;
        boolean afterDraw = false;
        PlayerLogs playerLogs = PlayerLogs.of(getPlayerLogs());
        for (int i = 0; i <= line.getDrawLineCount(); i++) {
            afterDraw = (line.getDrawLineCount() > i) ? line.getDrawByPosition(i).getDrawableStatus() : false;
            getPlayerByName(playerLogs.getPlayerNameByPositionIndex(Position.of(i).getIndex())).move(beforeDraw, afterDraw);
            beforeDraw = afterDraw;
        }
    }

    public Player getPlayerByPosition(Position position) {
        return players.stream()
                    .filter(p -> p.getPosition().equals(position))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
    }

    public Player getPlayerByName(String name) {
        return players.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Position> getPlayerResultPosition() {
        return players.stream()
                .map(p -> p.getPosition())
                .collect(Collectors.toList());
    }

}
