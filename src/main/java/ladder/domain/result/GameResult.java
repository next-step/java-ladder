package ladder.domain.result;

import ladder.domain.Records;
import ladder.domain.participants.Participants;
import ladder.utils.SplitUtils;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    private final List<Reward> rewards;

    public GameResult(String inputText) {
        this(SplitUtils.split(inputText));
    }

    public GameResult(String[] items) {
        this(GameResultFactory.createRewords(items));
    }

    public GameResult(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public List<Reward> getRewords() {
        return rewards;
    }

    public Records recordResult(Participants participants) {
        return new Records(rewards.stream()
                .map(participants::mapTo)
                .collect(Collectors.toList()));
    }
}
