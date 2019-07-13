package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private List<Prize> prizes;

    private Prizes(List<String> prizes) {
        this.prizes = prizes.stream().map(Prize::of).collect(Collectors.toList());
    }

    public static Prizes of(String prizes) {
        return new Prizes(Arrays.stream(prizes.split(",")).collect(Collectors.toList()));
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
