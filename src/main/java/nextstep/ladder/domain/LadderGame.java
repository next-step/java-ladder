package nextstep.ladder.domain;

import nextstep.ladder.controller.dto.GameInfo;
import nextstep.ladder.domain.wrapper.Players;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    public LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public LadderGame(GameInfo gameInfo) {
        this(gameInfo.players(), gameInfo.ladder());
    }

    public String playersName() {
        return players.names();
    }

    public String ladder() {
        return ladder.toString();
    }

    public Players play() {
        List<Player> finished = IntStream.range(0, players.numOfPlayers())
            .mapToObj(i -> players.moveOne(i, ladder))
            .collect(Collectors.toUnmodifiableList());

        return new Players(finished);
    }
}
