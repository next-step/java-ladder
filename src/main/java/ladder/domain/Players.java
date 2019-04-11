package ladder.domain;

import lombok.Getter;

import java.util.*;

@Getter
public class Players {
    private List<Player> players = new ArrayList<>();

    Players(List<String> inputPlayers) {
        inputPlayers.forEach(inputPlayer -> {
            players.add(new Player(inputPlayer));
        });
    }

    public int maxNameLength() {
        return Collections.max(players, Comparator.comparing(Player::getNameLength)).getNameLength();
    }

    public int playerIndex(String UserName) {
        return players.indexOf(new Player(UserName));
    }

    public PlayResults play(Ladder ladder) {
        List<PlayResult> playerResults = new ArrayList<>();
        players.forEach(player -> {
            playerResults.add(new PlayResult(findPlayer(player.getName()), getGameResult(ladder, player.getName())));
        });
        return new PlayResults(playerResults);
    }

    public Player findPlayer(String name) {
        return findByName(name);
    }

    public GameResult getGameResult(Ladder ladder, String name) {
        return ladder.move(playerIndex(name));
    }

    private Player findByName(String playerName) {
        Optional<Player> findPlayer = players.stream().filter(player -> player.isEqualsName(playerName)).findFirst();
        return findPlayer.orElseThrow(() -> new IllegalArgumentException("없는유저에욤"));
    }
}
