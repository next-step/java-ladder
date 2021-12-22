package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Rewards {

    private static final String DELIMITER = ",";
    private static final String NULL_MESSAGE = "입력이 null일 수 없습니다.";
    private static final String EMPTY_MESSAGE = "입력이 비어있을 수 없습니다.";
    private static final int MIN_LENGTH = 1;

    private final List<Reward> value;

    public Rewards(String names) {
        this(toList(names));
    }

    private static List<Reward> toList(String names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }

        return Arrays.stream(names.split(DELIMITER))
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    public Rewards(List<Reward> rewards) {
        if (Objects.isNull(rewards)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }

        if (rewards.size() < MIN_LENGTH) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }

        this.value = rewards;
    }

    public Reward findByIndex(int index) {
        return value.get(index);
    }

    public int count() {
        return value.size();
    }

    public List<Reward> getValue() {
        return Collections.unmodifiableList(value);
    }

}
