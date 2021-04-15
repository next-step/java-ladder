package nextstep.refactoring.laddergame.engine.player;

import nextstep.refactoring.ladder.engine.Ladder;
import nextstep.refactoring.ladder.engine.Position;
import nextstep.refactoring.laddergame.engine.LadderCompatibleList;
import nextstep.refactoring.view.interfaces.ViewObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Players implements LadderCompatibleList<Player>, ViewObject<PlayersDto> {

    private final List<Player> playerList;

    private Players(List<Player> playerList) {
        this.playerList = playerList;
    }

    public static Players of(String... names) {
        return Players.of(Arrays.asList(names));
    }

    public static Players of(List<String> names) {
        return IntStream.range(0, names.size())
                        .mapToObj(i -> Player.of(names.get(i), Position.of(i)))
                        .collect(collectingAndThen(toList(), Players::new));
    }

    @Override
    public Player get(Position position) {
        return playerList.get(position.getIndex());
    }

    @Override
    public Stream<Player> stream() {
        return playerList.stream();
    }

    @Override
    public boolean isNotCompatible(Ladder ladder) {
        return playerList.size() != ladder.numberOfPositions();
    }

    @Override
    public PlayersDto export() {
        return playerList.stream()
                         .map(Player::getName)
                         .collect(collectingAndThen(toList(), PlayersDto::new));
    }
}
