package ladder.domain;

import java.util.Iterator;
import java.util.List;

public class LadderMemberAndResult {

    private LadderMembers members;
    private LadderResults results;

    public LadderMemberAndResult(List<String> members, List<String> results) {
        if( members.size() != results.size() ) throw new IllegalArgumentException("참여자와 결과의 개수는 동일해야 합니다");
        this.members = new LadderMembers(members);
        this.results = new LadderResults(results);
    }

    public String toStringMembers() {
        return members.toString();
    }

    public String toStringResults() {
        return results.toString();
    }

    public int getPositionOfMember(LadderMember member) {
        return members.getPosition(member);
    }

    public LadderResult getResult(int pos) {
        return results.get(pos);
    }

    public Iterator<LadderMember> memberIterator() {
        return members.iterator();
    }
}
