package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameBoard {

    private final Players players;
    private final Ladder ladder;

    public GameBoard(Lines lines, Players players) {
        this.players = players;
        this.ladder = new Ladder(lines);
    }

    public GameBoard(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public static GameBoard of(Players players, Height height, BridgeCreationStrategy strategy) {
        Lines lines = Lines.of(players.totalNumber(), height, strategy);
        return new GameBoard(lines, players);
    }

    public void display(LadderVisitor visitor) {
        players.accept(visitor);
        ladder.accept(visitor);
    }

    public GameResults resultAll(Rewards rewards) {
        return new GameResults(IntStream.range(0, players.totalNumber())
                .mapToObj(players::findByOrder)
                .map(player -> result(player, rewards))
                .collect(Collectors.toList()));
    }

    public GameResult result(Player player, Rewards rewards) {
        return new GameResult(player, rewards.findByOrder(ladder.getEndColumn(players.getOrder(player))));
    }
}
