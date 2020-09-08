package ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(List<String> prizeNames, int countOfPoints) {
        validatePrizes(prizeNames, countOfPoints);
        List<Prize> prizes = prizeNames.stream()
                                        .map(Prize::new)
                                        .collect(Collectors.toList());
        return new Prizes(prizes);
    }

    public List<String> getPrizeNames() {
        return prizes.stream()
                .map(Prize::getPrize)
                .collect(Collectors.toList());
    }

    public Prize getPrizeByIndex(int index) {
        return prizes.get(index);
    }

    private static void validatePrizes(List<String> prizeNames, int countOfPoints) {
        if (prizeNames.size() != countOfPoints) {
            throw new IllegalArgumentException("실행 결과 개수는 참여자 수와 일치해야 합니다.");
        }
    }

}
