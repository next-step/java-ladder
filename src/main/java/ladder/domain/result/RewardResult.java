package ladder.domain.result;

import ladder.domain.ladders.reward.Prize;
import ladder.domain.participants.Name;

import java.util.Objects;

public class RewardResult {

    private final Name name;
    private final Prize prize;

    public RewardResult(String name, String prize) {
        this(new Name(name), new Prize(prize));
    }

    public RewardResult(Name name, Prize prize) {
        this.name = name;
        this.prize = prize;
    }

    public Name getName() {
        return name;
    }

    public Prize getPrize() {
        return prize;
    }

    public boolean isSameName(Name nameToFind) {
        return name.equals(nameToFind);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RewardResult)) return false;
        RewardResult that = (RewardResult) o;
        return Objects.equals(name, that.name) && Objects.equals(prize, that.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, prize);
    }
}
