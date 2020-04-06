package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(final String prizes) {
        this.prizes = Arrays.stream(prizes.split(","))
                            .map(Prize::new)
                            .collect(Collectors.toList())
        ;
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Prizes prizes1 = (Prizes) o;
        return Objects.equals(prizes, prizes1.prizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizes);
    }
}
