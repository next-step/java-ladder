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
        return GameResults.createResults(ladder, players, rewards);
    }

    public GameResult result(Player player, Rewards rewards) {
        return GameResults.createResults(ladder, players, rewards).resultByPlayer(player);
    }
}
