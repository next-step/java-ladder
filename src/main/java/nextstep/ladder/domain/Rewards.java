package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Rewards {
    public static final String TOO_FEW_REWARDS_MESSAGE = "결과는 2개 이상이어야 합니다.";
    private final List<Name> values;

    public Rewards(List<Name> values) {
        this.valid(values);
        this.values = values;
    }

    private void valid(List<Name> values) {
        if (values == null || values.size() < 2) {
            throw new IllegalArgumentException(TOO_FEW_REWARDS_MESSAGE);
        }
    }

    public Name get(int index) {
        return values.get(index);
    }

    public List<Name> asList() {
        return values;
    }

    public int size() {
        return values.size();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards = (Rewards) o;
        return Objects.equals(values, rewards.values);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(values);
    }
}
