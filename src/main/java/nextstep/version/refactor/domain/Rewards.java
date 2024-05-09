package nextstep.version.refactor.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Rewards {
    private List<String> prize;

    public Rewards(List<String> prize) {
        this.prize = prize;
    }

    public Rewards(String prizes) {
        this(Arrays.stream(prizes.split(",")).collect(Collectors.toUnmodifiableList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rewards)) return false;
        Rewards prize1 = (Rewards) o;
        return Objects.equals(prize, prize1.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(prize);
    }

    public String get(int i) {
        return this.prize.get(i);
    }

    public int size() {
        return this.prize.size();
    }
}
