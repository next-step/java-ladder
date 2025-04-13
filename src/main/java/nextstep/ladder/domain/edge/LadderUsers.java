package nextstep.ladder.domain.edge;

import nextstep.ladder.domain.line.Line;

import java.util.List;
import java.util.stream.Collectors;

public class LadderUsers {
    private final List<LadderUser> ladderUsers;

    public LadderUsers(List<LadderUser> ladderUsers) {
        if (ladderUsers.size() <= 1) {
            throw new IllegalArgumentException("유저는 2명 이상이여야 합니다.");
        }

        boolean hasDuplicatedName = ladderUsers.stream()
            .flatMap(user1 -> ladderUsers.stream().filter(user2 -> user1 != user2 && user1.isSameName(user2)))
            .findAny()
            .isPresent();
        if (hasDuplicatedName) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }

        boolean hasDuplicatedPosition = ladderUsers.stream()
            .flatMap(user1 -> ladderUsers.stream().filter(user2 -> user1 != user2 && user1.isSamePosition(user2)))
            .findAny()
            .isPresent();
        if (hasDuplicatedPosition) {
            throw new IllegalArgumentException("중복된 위치가 존재합니다.");
        }

        this.ladderUsers = ladderUsers;
    }

    public int size() {
        return ladderUsers.size();
    }

    public LadderUsers move(Line line) {
        return new LadderUsers(ladderUsers.stream().map(ladderUser -> ladderUser.move(line)).collect(Collectors.toList()));
    }

    public List<String> getNames() {
        return ladderUsers.stream().map(LadderUser::getName).collect(Collectors.toList());
    }

    public LadderPrizes result(LadderPrizes ladderPrizes) {
        return new LadderPrizes(ladderUsers.stream()
            .map(ladderUser -> ladderUser.result(ladderPrizes))
            .collect(Collectors.toList())
        );
    }
}
