package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private static final String PRIZE_SEPARATOR = ",";

    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = new ArrayList<>(prizes);
    }

    public static Prizes from(String inputPrizes) {
        return new Prizes(Arrays
                .stream(inputPrizes.split(PRIZE_SEPARATOR))
                .map(String::trim)
                .map(Prize::from)
                .collect(Collectors.toList()));
    }

    Prize findPrizeByPosition(Position position) {
        return prizes.get(position.getPosition());
    }

    int numberOfPrizes() {
        return prizes.size();
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
