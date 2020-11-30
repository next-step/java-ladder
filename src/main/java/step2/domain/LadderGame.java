package step2.domain;

import step2.dto.PlayersRewardsDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private LadderGame() {}

    public static LadderGameResult runGame(final Ladder ladder, final PlayersRewardsDto playersRewardsDto) {

        List<PlayerGamePosition> playerPositions = IntStream.range(0, getPlayerCount(playersRewardsDto))
                .mapToObj(position -> new PlayerGamePosition(position, getPlayerCount(playersRewardsDto)))
                .collect(Collectors.toList());


        for (int i = 0; i < ladder.getLines().size(); i++) {
            moveLadder(ladder, playerPositions, i);
        }

        return new LadderGameResult(mapPlayerReward(playersRewardsDto, playerPositions));
    }

    private static Map<String, String> mapPlayerReward(PlayersRewardsDto playersRewardsDto, List<PlayerGamePosition> playerPositions) {
        Map<String, String> rewards = new HashMap<>();
        for (int i = 0; i < playerPositions.size(); i++) {
            rewards.put(getPlayerName(playersRewardsDto, i), getRewardName(playersRewardsDto, playerPositions, i));
        }
        return rewards;
    }

    private static String getRewardName(PlayersRewardsDto playersRewardsDto, List<PlayerGamePosition> playerPositions, int i) {
        return getRewards(playersRewardsDto).get(playerPositions.get(i).getPosition()).getName();
    }

    private static String getPlayerName(PlayersRewardsDto playersRewardsDto, int i) {
        return getPlayers(playersRewardsDto).get(i).getName();
    }

    private static List<Reward> getRewards(PlayersRewardsDto playersRewardsDto) {
        return playersRewardsDto.getRewards().getRewards();
    }

    private static List<Player> getPlayers(PlayersRewardsDto playersRewardsDto) {
        return playersRewardsDto.getPlayers().getPlayers();
    }

    private static void moveLadder(Ladder ladder, List<PlayerGamePosition> playerPositions, int i) {
        for (PlayerGamePosition playerPosition : playerPositions) {
            playerPosition.move(ladder.getLines().get(i).getDirections().get(playerPosition.getPosition()).getDirection());
        }
    }

    private static int getPlayerCount(PlayersRewardsDto playersRewardsDto) {
        return playersRewardsDto.getPlayers().getPlayersCount();
    }
}
