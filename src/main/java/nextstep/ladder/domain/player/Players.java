package nextstep.ladder.domain.player;

import nextstep.ladder.domain.player.exception.UnknownPlayerException;
import nextstep.ladder.dto.PlayerDto;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Players {

    private final List<Player> playerList;

    private Players(List<Player> playerList) {
        this.playerList = playerList;
    }

    public static Players of(List<String> playerNames) {
        return IntStream.range(0, playerNames.size())
                        .mapToObj(i -> new Player(playerNames.get(i), i))
                        .collect(collectingAndThen(toList(), Players::new));
    }

    public Player searchBy(Name name) {
        return playerList.stream()
                         .filter(player -> player.hasName(name))
                         .findFirst()
                         .orElseThrow(UnknownPlayerException::new);
    }

    public int getSize() {
        return playerList.size();
    }

    public List<PlayerDto> export() {
        return playerList.stream()
                         .map(Player::export)
                         .collect(toList());
    }

}
