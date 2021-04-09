package nextstep.ladder.service;

import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.Reward;
import nextstep.ladder.domain.User;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LadderResult {

    public static final String GUIDE_ERR_NOT_FOUND_USER = "존재하지 않는 아이디 입니다.";
    private final Map<User, Reward> rewardResult;

    private LadderResult(final Map<User, Reward> rewardResult) {
        this.rewardResult = rewardResult;
    }

    public static LadderResult valueOf(final Map<User, Reward> result) {
        return new LadderResult(result);
    }

    public static LadderResult rideLadder(
            final Participants participants, final Ladder ladder, final LadderRewards ladderRewards) {

        Map<User, Reward> result = new LinkedHashMap<>();
        Set<User> users = participants.getUsers();

        for (User user : users) {
            Position rewardPosition = ladder.findEndPosition(user.position());
            Reward reward = ladderRewards.findReward(rewardPosition);
            result.put(user, reward);
        }

        return LadderResult.valueOf(result);
    }

    public String findOf(final User user) {
        return rewardResult.entrySet()
                .stream()
                .filter(u -> u.getKey().match(user))
                .map(Map.Entry::getValue)
                .findAny()
                .map(Reward::toString)
                .orElse(GUIDE_ERR_NOT_FOUND_USER);
    }

    public List<String> findAll() {
        return rewardResult.entrySet()
                .stream()
                .map(this::toString)
                .collect(Collectors.toList());
    }

    private String toString(final Map.Entry<User, Reward> userRewardEntry) {
        return String.format("%s : %s", userRewardEntry.getKey(), userRewardEntry.getValue());
    }
}
