package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderGenerator;
import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;
import ladder.vo.LadderSize;
import ladder.vo.Length;

import java.util.List;

public class LadderGameGenerator {
    private final LadderGenerator ladderGenerator;

    public LadderGameGenerator(LadderGenerator ladderGenerator) {
        this.ladderGenerator = ladderGenerator;
    }

    public LadderGame generate(MemberGroup memberGroup, Length height) {
        List<Member> members = memberGroup.getMembers();
        Length width = new Length(members.size() - 1);
        LadderSize ladderSize = new LadderSize(width, height);

        Ladder ladder = ladderGenerator.generateLadder(ladderSize);

        return new LadderGame(memberGroup, ladder);
    }
}
