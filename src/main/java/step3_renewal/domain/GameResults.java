package step3_renewal.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameResults {

    private List<GameResult> gameResults;

    private GameResults(final List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public static GameResults of(final List<GameResult> gameResults) {
        return new GameResults(gameResults);
    }

    public List<GameResult> getGameResults() {
        return Collections.unmodifiableList(gameResults);
    }

    public static GameResults results(Participants participants, Rewards rewards, Ladder ladder) {
        List<GameResult> list =
                participants.participants()
                        .stream()
                        .map(participant -> gameResult(participant, rewards, ladder))
                        .collect(Collectors.toList());
        return new GameResults(list);
    }

    private static GameResult gameResult(Participant participant, Rewards rewards, Ladder ladder) {
        return GameResult.of(participant.name()
                , rewards.getRewardName(ladder.move(participant.position())));
    }
}
