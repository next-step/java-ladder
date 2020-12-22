package ladder.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LadderGameResult {
    private final Ladder ladder;
    private final Map<LadderMember, LadderResult> ladderResults;

    public LadderGameResult(Ladder ladder, Map<LadderMember, LadderResult> ladderResults) {
        this.ladder = ladder;
        this.ladderResults = ladderResults;
    }

    public LadderResult getLadderResult(String memberName){
        return ladderResults.keySet()
                .stream()
                .filter( member -> member.getName().equals(memberName))
                .map( member -> ladderResults.get(member) )
                .findFirst()
                .get();
    }

    public LadderReader getLadderReader(){
        return ladder.getReader();
    }

    public Map<LadderMember, LadderResult> getAllLadderResult() {
        return ladderResults;
    }

    public Set<LadderMember> getAllLadderMembers(){
        return ladderResults.keySet();
    }

    public Set<LadderResult> getAllLadderResults(){
        return new HashSet<>(ladderResults.values());
    }
}
