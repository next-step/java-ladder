package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    static final String ALERT_INVALID_NUMBER_OF_PRIZES = "상품의 수는 참여자 수와 같아야 합니다.";
    private static final String PRIZE_SEPARATOR = ",";

    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes, int numberOfPlayers) {
        if (prizes.size() != numberOfPlayers) {
            throw new IllegalArgumentException(ALERT_INVALID_NUMBER_OF_PRIZES);
        }
        this.prizes = new ArrayList<>(prizes);
    }

    public static Prizes from(String inputPrizes, int numberOfPlayers) {
        return new Prizes(Arrays
                .stream(inputPrizes.split(PRIZE_SEPARATOR))
                .map(String::trim)
                .map(Prize::from)
                .collect(Collectors.toList()), numberOfPlayers);
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
