package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GamePrizesGroup {

    private final List<GamePrize> gamePrizes;

    private GamePrizesGroup(List<GamePrize> gamePrizes) {
        this.gamePrizes = gamePrizes;
    }

    public static GamePrizesGroup of(List<String> gamePrizeNames, PlayersGroup playersGroup) {
        validateGamePrizeCounts(gamePrizeNames, playersGroup);
        List<GamePrize> gamePrizes = gamePrizeNames.stream()
                .map(GamePrize::new)
                .collect(Collectors.toList());
        return new GamePrizesGroup(gamePrizes);
    }

    private static void validateGamePrizeCounts(List<String> gamePrizeNames, PlayersGroup playersGroup) {
        if (gamePrizeNames.size() != playersGroup.getPlayerCounts()) {
            throw new LadderBuildingException(LadderBuildingException.INVALID_GAME_PRIZE_COUNTS);
        }
    }

    public String getGamePrizeNameByIndex(int index) {
        return gamePrizes.get(index).getName();
    }

    public List<String> getGamePrizeNames() {
        return gamePrizes.stream()
                .map(GamePrize::getName)
                .collect(Collectors.toList());
    }
}
