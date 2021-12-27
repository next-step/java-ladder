package ladderstep4.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    public static final String CANNOT_FIND_PRIZE_MESSAGE = "찾을 수 없는 포지션값입니다.";

    private static final String DELIMITER = ",";

    private final List<Prize> values;

    public Prizes(String prizes) {
        this(Arrays.stream(prizes.split(DELIMITER))
                .map(Prize::new)
                .collect(Collectors.toList()));
    }

    public Prizes(List<Prize> prizes) {
        this.values = prizes;
    }

    public Prize findPrize(Position position) {
        if (position.value() >= values.size()) {
            throw new IllegalArgumentException(CANNOT_FIND_PRIZE_MESSAGE);
        }
        return values.get(position.value());
    }

    public int size() {
        return values.size();
    }

    public List<Prize> getValues() {
        return Collections.unmodifiableList(values);
    }
}
