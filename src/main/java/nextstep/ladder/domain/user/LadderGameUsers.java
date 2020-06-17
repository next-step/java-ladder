package nextstep.ladder.domain.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LadderGameUsers {
    private final List<LadderGameUser> ladderGameUsers;

    public LadderGameUsers(final List<LadderGameUser> ladderGameUsers) {
        this.ladderGameUsers = ladderGameUsers;
        validateUserNames(this.ladderGameUsers);
    }

    private void validateUserNames(Collection<LadderGameUser> ladderGameUsers) {
        Set<LadderGameUser> uniqueUsers = new HashSet<>(ladderGameUsers);
        if (uniqueUsers.size() != ladderGameUsers.size()) {
            throw new IllegalArgumentException("LadderGameUser는 중복된 이름을 가질 수 없습니다.");
        }
    }

    public List<LadderGameUser> getLadderGameUsers() {
        return ladderGameUsers;
    }

    public List<String> getLadderGameUserNames() {
        return ladderGameUsers.stream()
                .map(LadderGameUser::getUserName)
                .collect(Collectors.toList());
    }

    public int size() {
        return ladderGameUsers.size();
    }

}
