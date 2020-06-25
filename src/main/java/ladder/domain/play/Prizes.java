package ladder.domain.play;

import java.util.List;

public class Prizes extends Items {
    private Prizes(List<String> items) {
        super(items);
    }

    public static Prizes of(List<String> prizes) {
        return new Prizes(prizes);
    }
}