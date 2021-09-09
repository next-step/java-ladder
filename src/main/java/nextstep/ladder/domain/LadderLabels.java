package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderLabels {

    private final List<String> playerNames;
    private final List<String> prizeNames;

    private LadderLabels(List<String> playerNames, List<String> prizeNames) {
        this.playerNames = Objects.requireNonNull(playerNames);
        this.prizeNames = Objects.requireNonNull(prizeNames);
    }

    public static LadderLabels from(Players players, LadderGamePrizes ladderGamePrizes) {
        List<String> playerNames = players.value().stream()
            .map(Player::getName)
            .collect(Collectors.toList());

        List<String> prizeNames = ladderGamePrizes.value().stream()
            .map(LadderGamePrize::getPrizeName)
            .collect(Collectors.toList());

        return new LadderLabels(playerNames, prizeNames);
    }

    public static LadderLabels from(String[] playerNamesArray, String[] prizeNamesArray) {
        List<String> playerNames = Arrays.asList(playerNamesArray);
        List<String> prizeNames = Arrays.asList(prizeNamesArray);

        return new LadderLabels(playerNames, prizeNames);
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public List<String> getPrizeNames() {
        return prizeNames;
    }
}
