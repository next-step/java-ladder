package nextstep.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static nextstep.ladder.CommonConstans.SEPARATOR_COMMA;

public class Reward {

    private List rewardList = new ArrayList();

    public Reward(String reward, int playerCount) {
        checkVaild(reward.trim().split(SEPARATOR_COMMA), playerCount);

        setRewardList(reward.trim().split(SEPARATOR_COMMA));
    }


    public static Reward of(String reward, int playerCount) {

        return new Reward(reward, playerCount);
    }

    private void setRewardList(String[] rewards) {
        for (String reward : rewards) {
            rewardList.add(reward);
        }
    }

    public List<String> getRewardList() {
        return Collections.unmodifiableList(rewardList);
    }

    private void checkVaild(String[] rewards, int playerCount) {
        if (rewards.length != playerCount) {
            throw new IllegalArgumentException("보상리스트는 플레이어 수와 같아야 됩니다");
        }
    }
}
