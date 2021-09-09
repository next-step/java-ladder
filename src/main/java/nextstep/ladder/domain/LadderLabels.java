package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderLabels {

    private final List<String> playerNames;
    private final List<String> prizeNames;

    public LadderLabels(List<String> playerNames, List<String> prizeNames) {
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

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public List<String> getPrizeNames() {
        return prizeNames;
    }
}
