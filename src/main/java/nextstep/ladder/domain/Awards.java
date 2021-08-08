package nextstep.ladder.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Awards {
    private Winners winners;

    public Awards() {
    }

    public void award(Members members, Prizes prizes, Ladder ladder) {
        winners = members.stream()
            .map(member -> Winner.of(member, prizes.findByIndex(ladder.result(members.findPosition(member)))))
            .collect(collectingAndThen(toList(), Winners::create));
    }

    public Winners winners() {
        return winners;
    }

    public Winner findWinnerByName(String name) {
        Member member = Member.of(name);
        return winners.stream()
            .filter(winner -> winner.member().equals(member))
            .findFirst().orElseThrow(() -> new MemberNotFoundException("참여자를 찾을 수 없습니다."));
    }
}
