package ladder.domain.result;

import ladder.domain.participants.Name;
import ladder.exception.NameNotFoundException;

import java.util.List;
import java.util.Objects;

public class GameRecords {

    private final List<RewardResult> rewardResults;

    public GameRecords(List<RewardResult> rewardResults) {
        this.rewardResults = rewardResults;
    }

    public List<RewardResult> getRewardGamers() {
        return rewardResults;
    }

    public RewardResult find(Name nameToFind) {
        return this.rewardResults.stream()
                .filter(result -> result.isSameName(nameToFind))
                .findFirst()
                .orElseThrow(() -> new NameNotFoundException(nameToFind));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameRecords)) return false;
        GameRecords gameRecords = (GameRecords) o;
        return Objects.equals(rewardResults, gameRecords.rewardResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardResults);
    }
}
