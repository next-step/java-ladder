package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Rewards {
    private static final String NO_MATCH_MEMBER_COUNT_MESSAGE = "참여자수와 실행결과 입력 수는 일치해야합니다.";
    private static final String DEFAULT_SPLIT_CHARACTER = ",";

    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards from(String rewards) {
        return new Rewards(toRewards(getRewards(rewards)));
    }

    public static Rewards of(String... rewards) {
        return new Rewards(toRewards(rewards));
    }

    public static Rewards of(String rewards, Members members) {
        List<Reward> rewardGroup = toRewards(getRewards(rewards));
        validateRewards(rewardGroup, members);
        return new Rewards(rewardGroup);
    }

    private static void validateRewards(List<Reward> rewardGroup, Members members) {
        if (rewardGroup.size() != members.countOfMember()) {
            throw new IllegalArgumentException(NO_MATCH_MEMBER_COUNT_MESSAGE);
        }
    }

    private static List<Reward> toRewards(String[] rewards) {
        return Arrays.stream(rewards)
                            .map(Reward::new)
                            .collect(Collectors.toList());
    }

    private static String[] getRewards(String rewards) {
        String[] splitMemberNames = rewards.split(DEFAULT_SPLIT_CHARACTER);
        return splitMemberNames;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public Reward getReward(int position) {
        return rewards.get(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards1 = (Rewards) o;
        return Objects.equals(rewards, rewards1.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewards);
    }
}
