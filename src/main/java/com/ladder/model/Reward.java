package com.ladder.model;

import com.ladder.exception.NameLengthException;
import com.ladder.utils.AssertUtils;

import java.util.Objects;

public class Reward {

    static final int LENGTH_OF_REWARD_NAME = 5;

    private String reward;

    private Reward(String reward) {
        this.reward = reward;
    }

    public static Reward of(String reward) {
        AssertUtils.checkNull(reward);
        if (reward.length() > LENGTH_OF_REWARD_NAME) {
            throw new NameLengthException(reward);
        }
        return new Reward(reward);
    }

    public String getReward() {
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward1 = (Reward) o;
        return Objects.equals(reward, reward1.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reward);
    }

    @Override
    public String toString() {
        return "Reward{" +
                "reward='" + reward + '\'' +
                '}';
    }
}