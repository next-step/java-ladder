package nextstep.ladder.domain.user;

import java.util.*;
import java.util.stream.Collectors;

public class LadderGameUserStorage {
    private final List<LadderGameUser> ladderGameUsers;

    public LadderGameUserStorage(final List<LadderGameUser> ladderGameUsers) {
        this.ladderGameUsers = ladderGameUsers;
        validateUserNames(this.ladderGameUsers);
    }

    private void validateUserNames(Collection<LadderGameUser> ladderGameUsers) {
        Set<LadderGameUser> uniqueUsers = new HashSet<>(ladderGameUsers);
        if (uniqueUsers.size() != ladderGameUsers.size()) {
            throw new IllegalArgumentException("LadderGameUser는 중복된 이름을 가질 수 없습니다.");
        }
    }

    public List<LadderGameUser> findAll() {
        return Collections.unmodifiableList(ladderGameUsers);
    }

    public LadderGameUser findByUserName(final String userName) {
        return ladderGameUsers.stream()
                .filter(user -> user.getUserName().equals(userName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s에 해당하는 사용자는 없습니다", userName)));
    }

    public List<String> getLadderGameUserNames() {
        return ladderGameUsers.stream()
                .map(LadderGameUser::getUserName)
                .collect(Collectors.toList());
    }

    public int count() {
        return ladderGameUsers.size();
    }
}
