package step4_ladderGame.domain;

import step4_ladderGame.dto.PlayersDto;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Players {

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(String[] names) {
        List<Player> players = IntStream.range(0, names.length)
                .mapToObj(index -> Player.of(names[index], index))
                .collect(toList());
        return Players.of(players);
    }

    public static Players of(List<Player> players) {
        return new Players(players);
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public int size() {
        return players.size();
    }

    public Players play(Ladder ladder) {
        return players.stream()
                .map(ladder::move)
                .collect(collectingAndThen(toList(), Players::new));
    }

    public PlayersDto toDto() {
        return players.stream()
                .map(Player::toDto)
                .collect(collectingAndThen(toList(), PlayersDto::new));
    }
    
    public String isPlayerPosition(Position position) {
        return players.stream()
                .filter(player -> player.getPosition().equals(position))
                .map(Player::name)
                .collect(toList()).get(0);
    }
}
