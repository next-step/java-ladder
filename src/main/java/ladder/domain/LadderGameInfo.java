package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGameInfo {
    private final Users users;
    private final LadderRewards ladderRewards;

    public LadderGameInfo(final Users users, final LadderRewards ladderRewards) {
        if (users.size() != ladderRewards.size()) {
            throw new IllegalArgumentException("참여할 사람과 실행 결과의 수는 같아야 한다.");
        }
        this.users = users;
        this.ladderRewards = ladderRewards;
    }

    public Map<User, LadderReward> match(Map<Position, Position> ladderResults) {
        return ladderResults.entrySet()
                .stream()
                .collect(Collectors.toMap(entry -> users.getUser(entry.getKey()),
                        entry -> ladderRewards.getReward(entry.getValue())));
    }

    public int userSize() {
        return users.size();
    }

    public List<User> getUsers() {
        return users.getUsers();
    }

    public List<LadderReward> getLadderRewards() {
        return ladderRewards.getRewards();
    }
}
