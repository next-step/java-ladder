package step2.domain;

import step2.dto.PlayersRewardsDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {


    public static LadderGameResult runGame(final Ladder ladder, final PlayersRewardsDto playersRewardsDto) {

        List<PlayerGamePosition> playerPositions = IntStream.range(0, getPlayerCount(playersRewardsDto))
                .mapToObj(position -> new PlayerGamePosition(position, getPlayerCount(playersRewardsDto)))
                .collect(Collectors.toList());


        for (int i = 0; i < ladder.getLines().size(); i++) {
            for (int j = 0; j < playerPositions.size(); j++) {
                playerPositions.get(j).move(ladder.getLines().get(i).getLadderPoints().get(playerPositions.get(j).getPosition()).getDirection());
            }
        }

        Map<String, String> rewards = new HashMap<>();
        for (int i = 0; i < playerPositions.size(); i++) {
            rewards.put(playersRewardsDto.getPlayers().getPlayers().get(i).getName(), playersRewardsDto.getRewards().getRewards().get(playerPositions.get(i).getPosition()).getName());
        }
        return new LadderGameResult(rewards);
    }

    private static int getPlayerCount(PlayersRewardsDto playersRewardsDto) {
        return playersRewardsDto.getPlayers().getPlayersCount();
    }
}
