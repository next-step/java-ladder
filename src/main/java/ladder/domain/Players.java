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

    public int playerIndex(Player player) {
        return players.indexOf(player);
    }

    public PlayResults play(Ladder ladder) {
        List<PlayResult> playerResults = new ArrayList<>();
        players.forEach(player -> playerResults.add(new PlayResult(findPlayer(player), getGameResult(ladder, player))));
        return new PlayResults(playerResults);
    }

    public GameResult getGameResult(Ladder ladder, Player player) {
        return ladder.move(playerIndex(player));
    }

    private Player findPlayer(Player searchPlayer) {
        Optional<Player> findPlayer = players.stream().filter(player -> player.isEquals(searchPlayer)).findFirst();
        return findPlayer.orElseThrow(() -> new IllegalArgumentException("없는유저에욤"));
    }
}
