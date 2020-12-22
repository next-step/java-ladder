package ladder.domain;

import java.util.List;
import java.util.function.Consumer;

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

    public LadderResult getResult(int pos) {
        return results.get(pos);
    }

    public void forEachMember(Consumer<LadderMember> action) {
        members.stream().forEach(action);
    }

    public LadderMember findMember(String memberName) {
        return members.findFirst( member -> member.getName().equals(memberName));
    }
}
