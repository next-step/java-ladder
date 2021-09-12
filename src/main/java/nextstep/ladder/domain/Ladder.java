package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import nextstep.ladder.strategy.DrawLineStrategy;

public class Ladder {

    private final List<String> playerNames;
    private final List<String> prizeNames;
    private final List<LadderStep> ladderSteps;

    private Ladder(LadderGameSettings settings, DrawLineStrategy strategy) {
        this.playerNames = extractPlayerNames(settings.getPlayers());
        this.prizeNames = extractPrizeNames(settings.getLadderGamePrizes());
        this.ladderSteps = createLadderSteps(settings, strategy);
    }

    public static Ladder from(LadderGameSettings settings, DrawLineStrategy strategy) {
        return new Ladder(settings, strategy);
    }

    private List<LadderStep> createLadderSteps(LadderGameSettings settings, DrawLineStrategy strategy) {

        final int ladderHeight = settings.getLadderHeight().value();
        final int playersCount = settings.getPlayers().count();

        return Stream.generate(() -> new LadderStep(playersCount, strategy))
            .limit(ladderHeight)
            .collect(Collectors.toUnmodifiableList());
    }

    private List<String> extractPlayerNames(Players players) {
        return players.value().stream()
            .map(Player::getName)
            .collect(Collectors.toUnmodifiableList());
    }

    private List<String> extractPrizeNames(LadderGamePrizes prizes) {
        return prizes.value().stream()
            .map(LadderGamePrize::getPrizeName)
            .collect(Collectors.toUnmodifiableList());
    }

    public List<LadderStep> getLadderSteps() {
        return ladderSteps;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public List<String> getPrizeNames() {
        return prizeNames;
    }
}
