package ladder.domain;


import ladder.LadderUtil;

import java.util.Collections;
import java.util.List;

public class Reward {

    private List<String> rewards;

    private Reward(List<String> rewards, int userCount) {
        checkRewardCountValidation(rewards.size(), userCount);
        this.rewards = rewards;
    }

    public static Reward of(String rewards, int userCount) {
        return new Reward(LadderUtil.splitStringByComma(rewards), userCount);
    }

    private void checkRewardCountValidation(int rewardCount, int userCount) {
        if (rewardCount != userCount) {
            throw new UnmatchRewardCountException("보상의 개수 " + rewardCount + "개와 유저의 수 " + userCount + " 명이 일치하지 않습니다.");
        }
    }

    public List<String> toList() {
        return Collections.unmodifiableList(rewards);
    }
}
