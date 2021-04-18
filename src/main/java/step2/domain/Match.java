package step2.domain;

import java.util.List;

public class Match {
    private static final int NOT_FOUND = -1;
    private final int matchIndex;

    public Match(Member member, Members members, Ladder ladder) {
        int memberIndex = getMatchMemberIndex(member, members);
        this.matchIndex = ladder.getResultOfMember(memberIndex);
    }

    private int getMatchMemberIndex(Member member, Members members) {
        int memberIndex = members.indexOf(member);
        if (memberIndex == NOT_FOUND) {
            throw new IllegalArgumentException("해당 사용자는 사다리 게임에 참여하지 않았습니다.");
        }
        return memberIndex;
    }

    public String getMatchOfResult(Results results) {
        return results.getResultOfMember(this.matchIndex);
    }

    public List<Result> getMatchOfAll(Results results) {
        return results.getResultOfAllMember();
    }
}
