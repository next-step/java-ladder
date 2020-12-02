package step2.domain;

import java.util.stream.Collectors;

public class LadderGame {

    private LadderGame() {}

    public static PlayerRewardMatches runGame(Players players, Rewards rewards, Ladder ladder) {
        return PlayerRewardMatches.of(
                players.getPlayers()
                        .stream()
                        .map(player ->
                                PlayerRewardMatch.of(player.getPlayerGameName(), rewards.getRewards().get(ladder.moveAll(player.getPlayerGamePosition())).getRewardName())).
                        collect(Collectors.toList()));
    }
}
