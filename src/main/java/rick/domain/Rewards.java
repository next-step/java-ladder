package rick.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Rewards {

    private static final String EXCEPTION_MESSAGE_CAN_NOT_BE_NULL = "보상 목록이 null 일 수 없습니다.";
    private static final String EXCEPTION_MESSAGE_CAN_NOT_BE_EMPTY = "보상 목록이 비어 있습니다.";

    private final List<Reward> rewards;

    public Rewards(List<String> names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_CAN_NOT_BE_NULL);
        }

        if (names.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_CAN_NOT_BE_EMPTY);
        }

        rewards = names.stream()
            .map(Reward::new)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public Reward reward(int index) {
        return rewards.get(index);
    }

    public List<Reward> getRewards() {
        return rewards;
    }


}
