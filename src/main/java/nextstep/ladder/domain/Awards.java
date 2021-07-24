package nextstep.ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Awards {
    private Winners winners;

    public Awards() {
    }

    public void award(Members members, Prizes prizes, Ladder ladder) {
        winners = Winners.create(StreamSupport.stream(members.spliterator(), false)
            .map(member -> Winner.of(member, prizes.findByIndex(ladder.result(members.findHorizontalNumber(member)))))
            .collect(Collectors.toList()));
    }

    public Winners winners() {
        return winners;
    }

    public Winner findWinnerByName(String name) {
        return StreamSupport.stream(winners.spliterator(), false)
            .filter(winner -> winner.member().equals(Member.of(name)))
            .findFirst().orElseThrow(() -> new IllegalArgumentException("참여자를 찾을 수 없습니다."));
    }
}
