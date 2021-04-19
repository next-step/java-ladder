package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<String> prizeNames) {
        prizes = new ArrayList<>();
        prizeNames.stream()
                .map(Prize::new)
                .forEach(prizes::add);
    }

    public Prize get(int i) {
        return prizes.get(i);
    }

    public List<String> getAllPrizesName() {
        return prizes.stream()
                .map(Prize::toString)
                .collect(Collectors.toList());
    }

    public int getPrizeCount() {
        return prizes.size();
    }
}
