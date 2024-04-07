package ladder.domain.result;

import ladder.domain.participants.Name;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Records {

    private final List<RewardResult> rewardResults;

    public Records(List<RewardResult> rewardResults) {
        this.rewardResults = rewardResults;
    }

    public List<RewardResult> getRewardGamers() {
        return rewardResults;
    }

    public Records find(Name nameToFind) {
        return new Records(this.rewardResults.stream()
                .filter(e -> e.isSameName(nameToFind)).collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Records)) return false;
        Records records = (Records) o;
        return Objects.equals(rewardResults, records.rewardResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardResults);
    }
}
