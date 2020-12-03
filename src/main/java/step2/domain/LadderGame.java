package step2.domain;

import java.util.stream.Collectors;

public class LadderGame {

    private LadderGame() {
    }

    public static GameResults runGame(Players players, Rewards rewards, Ladder ladder) {
        return GameResults.of(
                players.getPlayers()
                        .stream()
                        .map(player ->
                                GameResult.of(
                                        player.getPlayerGameName(), rewards.getRewardName(ladder.moveAll(player.getPlayerGamePosition()))))
                        .collect(Collectors.toList()));
    }
}
