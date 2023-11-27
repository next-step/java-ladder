package ladder.domain;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }


    public static Prizes of(String... prizes) {
        return of(Arrays.asList(prizes));
    }

    public static Prizes of(List<String> prizes) {
        return new Prizes(prizes.stream()
                .map(Prize::from)
                .collect(Collectors.toList()));
    }

    public List<Prize> prizes() {
        return Collections.unmodifiableList(prizes);
    }

    public int size() {
        return prizes.size();
    }
}
