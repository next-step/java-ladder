package com.hskim.ladder.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Reward {
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String EXCEED_NAME_LENGTH_LIMIT = "보상명은 5자를 초과할 수 없습니다."; // 5자 == NAME_LENGTH_LIMIT
    private static final String EMPTY_NAME = "보상명은 공백이 될 수 없습니다.";

    private String name;

    public Reward(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(EXCEED_NAME_LENGTH_LIMIT);
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME);
        }
    }

    public static List<Reward> makeRewardsFromNames(List<String> names) {
        return names.stream()
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reward)) return false;
        Reward reward = (Reward) o;
        return Objects.equals(name, reward.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
