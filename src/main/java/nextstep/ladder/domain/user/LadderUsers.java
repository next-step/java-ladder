package nextstep.ladder.domain.user;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderUsers {
    private final List<LadderUser> ladderUsers;

    public LadderUsers(String names) {
        this.ladderUsers = Stream.of(names.split(",")).map(LadderUser::new).collect(Collectors.toList());

        if (new HashSet<>(this.ladderUsers).size() != ladderUsers.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }

        if (this.ladderUsers.size() <= 1) {
            throw new IllegalArgumentException("유저는 2명 이상이여야 합니다.");
        }
    }

    public int getSize() {
        return ladderUsers.size();
    }

    @Override
    public String toString() {
        return ladderUsers.stream()
            .map(LadderUser::toString)
            .collect(Collectors.joining(" ", "", ""));
    }
}
