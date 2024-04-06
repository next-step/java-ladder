package ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    public static final String INVALID_NUMBER_OF_PRIZES = "우승 상품의 개수는 참가자의 숫자와 동일해야 합니다.";

    private List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(List<String> prizes, int numberOfParticipants) {
        if (prizes.size() != numberOfParticipants) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PRIZES);
        }

        return new Prizes(convertStringsToPrizes(prizes));
    }

    private static List<Prize> convertStringsToPrizes(List<String> prizes) {
        return prizes.stream()
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    public Prize getPrizeAt(int index) {
        return prizes.get(index);
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

}
