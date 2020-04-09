package ladder.domain;

import ladder.exception.PrizeCountNotMatchException;
import ladder.exception.PrizeNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Prizes {
    private static final String SEPARATOR = ",";

    private final List<Prize> prizes;

    public Prizes(final String prizes, final int playerCount) {
        String[] splitPrizes = prizes.split(SEPARATOR);
        checkAvailablePrizes(splitPrizes.length, playerCount);
        this.prizes = Collections.unmodifiableList(createPrize(splitPrizes));
    }

    public Prize find(Position position) {
        return prizes.stream()
                     .filter(prize -> prize.match(position))
                     .findFirst()
                     .orElseThrow(PrizeNotFoundException::new);
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }

    private List<Prize> createPrize(final String[] splitPrizes) {
        List<Prize> prizes = new ArrayList<>();
        for (int index = 0; index < splitPrizes.length; index++) {
            prizes.add(new Prize(index, splitPrizes[index]));
        }
        return prizes;
    }

    private void checkAvailablePrizes(final int prizeCount, final int playerCount) {
        if (prizeCount != playerCount) {
            throw new PrizeCountNotMatchException(prizeCount);
        }
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
