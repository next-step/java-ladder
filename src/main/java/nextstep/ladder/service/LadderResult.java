package nextstep.ladder.service;

import nextstep.ladder.domain.Reward;
import nextstep.ladder.domain.User;

import java.util.List;
import java.util.Map;
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
