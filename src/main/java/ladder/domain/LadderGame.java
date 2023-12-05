package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class LadderGame {

    private final Members members;
    private final Ladder ladder;
    private final GameResults gameResults;

    public LadderGame(Members members, Ladder ladder, GameResults gameResults, String ladderClimber) {
        validateLadderClimber(members, ladderClimber);
        this.members = members;
        this.ladder = ladder;
        this.gameResults = gameResults;
    }

    public WinnerResult start() {
        Map<Member, GameResult> result = new LinkedHashMap<>();
        for (int memberPosition = 0; memberPosition < members.countOfMembers(); memberPosition++) {
            int resultPosition = ladder.climb(memberPosition);
            result.put(members.values().get(memberPosition), gameResults.values().get(resultPosition));
        }
        return new WinnerResult(result);
    }

    private void validateLadderClimber(Members members, String ladderClimber) {
        if (StringUtils.equals(ladderClimber, "all")) {
            return;
        }
        if (members.contains(ladderClimber)) {
            return;
        }
        throw new IllegalArgumentException("'결과를 보고 싶은 사람'엔 'all' 또는 '참여 멤버 중 한 명'을 입력해야합니다.");
    }
}
