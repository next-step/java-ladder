package nextstep.ladder.domain.player;

import nextstep.ladder.domain.LadderBoard;
import nextstep.ladder.domain.Reward;
import nextstep.ladder.domain.player.exception.UnknownPlayerException;
import nextstep.ladder.dto.PlayerDto;
import nextstep.ladder.util.Pair;

import java.util.List;
import java.util.function.Predicate;
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

    public List<Pair<Player, Reward>> getResult(LadderBoard ladderBoard, Predicate<Player> query) {
        return playerList.stream()
                         .filter(query)
                         .map(player -> new Pair<>(player, ladderBoard.getReward(player)))
                         .collect(toList());
    }

    public Player searchBy(String name) {
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
