package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GamePrize {
    private final List<Prize> prize;

    public GamePrize(List<Prize> prize) {
        this.prize = prize;
    }

    public static GamePrize generateGamePrize(String[] input) {
        final List<Prize> prize = Stream.of(input)
                .map(Prize::new)
                .collect(Collectors.toList());

        return new GamePrize(prize);
    }

    public List<Prize> prizeList() {
        return prize;
    }

    public Prize prizeOf(int index) {
        return prize.get(index);
    }
}
