package ladder.domain;

import ladder.exception.PrizeCountNotMatchException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Prizes {
    private static final String SEPARATOR = ",";

    private final List<Prize> prizes;

    public Prizes(final String prizes, final int playerCount) {
        String[] splitPrizes = prizes.split(SEPARATOR);
        checkAvailablePrizes(splitPrizes.length, playerCount);
        this.prizes = Arrays.stream(splitPrizes)
                            .map(Prize::new)
                            .collect(Collectors.toList());
    }

    private void checkAvailablePrizes(final int prizeCount, final int playerCount) {
        if (prizeCount != playerCount) {
            throw new PrizeCountNotMatchException(prizeCount);
        }
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
