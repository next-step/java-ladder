package step3.domain;

import step3.exception.EmptyRewardException;
import step3.utils.StringUtil;

public class Reward {
    private String name;

    private Reward(String name) {
        this.name = name;
    }

    public static Reward of(String name) {
        validate(name);
        return new Reward(name);
    }

    private static void validate(String reward) {
        if (StringUtil.isEmpty(reward)) {
            throw new EmptyRewardException();
        }
    }

    public String getName() {
        return name;
    }
}
