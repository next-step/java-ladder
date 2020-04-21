package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGameInfo {
    private final List<User> users;
    private final List<LadderReward> ladderRewards;

    public LadderGameInfo(List<User> users, List<LadderReward> ladderRewards) {
        if (users.size() != ladderRewards.size()) {
            throw new IllegalArgumentException("참여할 사람과 실행 결과의 수는 같아야 한다.");
        }
        this.users = users;
        this.ladderRewards = ladderRewards;
    }

    public Map<User, LadderReward> match(Map<Position, Position> ladderResults) {
        return ladderResults.entrySet()
                .stream()
                .collect(Collectors.toMap(entry -> users.get(entry.getKey().toInt()),
                        entry -> ladderRewards.get(entry.getValue().toInt())));
    }

    public List<User> getUsers() {
        return users;
    }

    public List<LadderReward> getLadderRewards() {
        return ladderRewards;
    }
}
