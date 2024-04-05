package domain;

import java.util.List;

public class GameBoard {

    private final Players players;
    private final Ladder ladder;

    public GameBoard(Lines lines, Players players) {
        this.players = players;
        this.ladder = new Ladder(lines);
    }

    public static GameBoard of(Players players, Height height, BridgeCreationStrategy strategy) {
        Lines lines = Lines.of(players.totalNumber(), height, strategy);
        return new GameBoard(lines, players);
    }

    public void display(LadderVisitor visitor) {
        players.accept(visitor);
        ladder.accept(visitor);
    }

    public Reward getReward(Player player, Rewards rewards) {
        Position position = players.getPosition(player);
        return rewards.findByPosition(ladder.getEndPositionByStartPosition(position).getX());
    }

    public GameResult result(Player player, Rewards rewards) {
        GameResult gameResult = new GameResult();
        if (player.isName("all")) {
            this.players.forEach(p -> {
                gameResult.add(p, getReward(p, rewards));
            });
            return gameResult;
        }
        gameResult.add(player, getReward(player, rewards));
        return gameResult;
    }
}
