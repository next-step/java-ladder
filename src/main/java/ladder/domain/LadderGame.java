package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private final Players players;
    private final Rewards rewards;
    private final Ladder ladder;

    private LadderGame(Players players, Rewards rewards, Ladder ladder) {
        this.players = players;
        this.rewards = rewards;
        this.ladder = ladder;
    }

    public static LadderGame init(Players players, Rewards rewards, Height height, PointGenerationStrategy strategy) {
        Ladder ladder = new Ladder(players, height, strategy);
        return new LadderGame(players, rewards, ladder);
    }

    public Reward playOne(String playerName) {
        int position = this.players.getPlayerPosition(playerName);

        for (Line line : this.ladder.getLines()) {
            position = line.move(position);
        }

        return this.rewards.getReward(position);
    }

    public Map<String, Reward> playAll() {
        Map<String, Reward> result = new HashMap<>();

        players.getPlayers()
                .forEach(player -> {
                    String name = player.getName();
                    Reward reward = playOne(name);
                    result.put(name, reward);
                });

        return result;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
