package nextstep.ladder.domain;

import java.util.*;

public class LadderGameUsers {
    private final Map<Integer, LadderGameUser> ladderGameUsers;

    public LadderGameUsers(final Map<Integer, LadderGameUser> ladderGameUsers) {
        this.ladderGameUsers = ladderGameUsers;
        validateUserNames(ladderGameUsers.values());
    }

    private void validateUserNames(Collection<LadderGameUser> ladderGameUsers) {
        Set<LadderGameUser> uniqueUsers = new HashSet<>(ladderGameUsers);
        if (uniqueUsers.size() != ladderGameUsers.size()) {
            throw new IllegalArgumentException("LadderGameUser는 중복된 이름을 가질 수 없습니다.");
        }
    }

    public List<LadderGameUser> getLadderGameUserNames() {
        return new ArrayList<>(ladderGameUsers.values());
    }

    public int size() {
        return ladderGameUsers.size();
    }

    public LadderGameUser findUserByOrder(final Integer order) {
        return ladderGameUsers.get(order);
    }
}
