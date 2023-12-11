package nextstep.ladder.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players fromString(List<String> playerNames) {
        if (playerNames == null) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        return new Players(playerNames.stream().map(Player::new).collect(Collectors.toList()));
    }

    public List<String> toStringPlayers() {
        return players.stream().map(Player::toStringName).collect(Collectors.toList());
    }

    public String gameResult(Player player, List<String> results) {
        Optional<Player> resultPlayer = this.players.stream().filter(p -> p.equals(player)).findFirst();
        if(resultPlayer.isPresent()){
            return resultPlayer.get().toStringResult(results);
        }
        throw new IllegalArgumentException("없는 참가자입니다.");
    }

    public String gameResults(List<String> results) {
        return this.players.stream().map(p -> p.toStringName() + " : " + p.toStringResult(results)).collect(Collectors.joining("\n"));
    }

    public void run(List<Line> lines) {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).moveLine(i, lines);
        }
    }
}
