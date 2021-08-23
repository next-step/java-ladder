package nextstep.ladder;

import org.assertj.core.util.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static nextstep.ladder.CommonConstans.*;

public class Reward {

    private List rewardList = Arrays.asList(new String[]{FIRST_REWARD, SECOND_REWARD});
    private List<Integer> playerRewardList = new ArrayList<>();

    public Reward(int playerCount) {
        setRewardList(playerCount);
    }

    public static Reward of(int playerCount) {
        return new Reward(playerCount);
    }

    private void setRewardList(int playerCount) {

        IntStream.range(NUMBER_ZERO + 2, playerCount)
                .forEach(index -> rewardList.add(BANG));

        Collections.shuffle(rewardList);

    }

    public List<String> getRewardList() {
        return Collections.unmodifiableList(rewardList);
    }

    public void setPlayerList(int player) {
        playerRewardList.add(player);
    }

    public List<Integer> getRewardResult() {
        return Collections.unmodifiableList(playerRewardList);
    }
}
