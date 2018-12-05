package net.chandol.ladder.v2.domain.prize;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Prizes {
    private List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(String... prizeValues) {
        List<Prize> prizes = Arrays.stream(prizeValues).map(Prize::new).collect(toList());
        return new Prizes(prizes);
    }

    public static Prizes of(List<String> prizeValues) {
        List<Prize> prizes = prizeValues.stream().map(Prize::new).collect(toList());
        return new Prizes(prizes);
    }

    public String createPrizesString() {
        return prizes.stream()
                .map(Prize::getPrizeWithFixedLength)
                .collect(joining(" "));
    }

    public Prize getPrize(int idx) {
        return this.prizes.get(idx);
    }
}
