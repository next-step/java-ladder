package step04.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderUser {
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String EXCEED_NAME_LENGTH_LIMIT = "유저 이름은 5자를 초과할 수 없습니다."; // 5자 == NAME_LENGTH_LIMIT
    private static final String EMPTY_NAME = "유저 이름은 공백이 될 수 없습니다.";

    private final String name;
    private Reward reward;

    public LadderUser(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public LadderUser withReward(Reward reward) {
        this.reward = reward;
        return this;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(EXCEED_NAME_LENGTH_LIMIT);
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME);
        }
    }

    public static List<LadderUser> makeUsersFromNames(List<String> names) {
        return names.stream()
                .map(LadderUser::new)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public String getRewardName() {
        return reward.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderUser)) return false;
        LadderUser that = (LadderUser) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
