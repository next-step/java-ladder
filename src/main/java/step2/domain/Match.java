package step2.domain;

import java.util.HashMap;
import java.util.Map;

public class Match {
    private final Map<String, String> match;

    private Match(Map<String, String> match) {
        this.match = match;
    }

    public static Match findOfResults(Members members, Ladder ladder, Results results, Member findMember) {
        if (findMember.isAllByName()) {
            return findMatchResultOfAll(members, ladder, results);
        }
        Map<String, String> returnMap = findResultsMatchingOfMember(members, ladder, results, findMember);
        return new Match(returnMap);
    }

    private static Map<String, String> findResultsMatchingOfMember(Members members, Ladder ladder, Results results, Member findMember) {
        Map<String, String> returnMap = new HashMap<>();
        int memberIndex = members.indexOf(findMember);
        int matchingOfResultIndex = ladder.getEndIndexByStartIndex(memberIndex);
        returnMap.put(members.getMemberOfIndex(memberIndex), results.getResultOfMember(matchingOfResultIndex));
        return returnMap;
    }

    private static Match findMatchResultOfAll(Members members, Ladder ladder, Results results) {
        Map<String, String> returnMap = new HashMap<>();
        for (int i = 0; i < members.getSize(); i++) {
            int matchingOfResultIndex = ladder.getEndIndexByStartIndex(i);
            returnMap.put(members.getMemberOfIndex(i), results.getResultOfMember(matchingOfResultIndex));
        }
        return new Match(returnMap);
    }

    public Map<String, String> getMatch() {
        return match;
    }
}
