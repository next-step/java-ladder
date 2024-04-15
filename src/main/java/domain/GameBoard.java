package domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameBoard {

    private final Players players;
    private final Ladder ladder;

    public GameBoard(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public static GameBoard of(Players players, Height height, BridgeCreationStrategy strategy) {
        Ladder ladder = new Ladder(IntStream.range(0, height.getHeight())
                .mapToObj(i -> Bridges.of(players.totalNumber(), strategy))
                .collect(Collectors.toList()));
        return new GameBoard(players, ladder);
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
