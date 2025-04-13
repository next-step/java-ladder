package nextstep.ladder.domain.user;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LadderUsers {
    private final List<LadderUser> ladderUsers;

    public LadderUsers(List<String> names) {
        this.ladderUsers = names.stream().map(LadderUser::new).collect(Collectors.toList());

        if (new HashSet<>(this.ladderUsers).size() != ladderUsers.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }

        if (this.ladderUsers.size() <= 1) {
            throw new IllegalArgumentException("유저는 2명 이상이여야 합니다.");
        }
    }

    public int size() {
        return ladderUsers.size();
    }

    public List<String> getLadderUserNames() {
        return ladderUsers.stream().map(LadderUser::getValue).collect(Collectors.toList());
    }
}
