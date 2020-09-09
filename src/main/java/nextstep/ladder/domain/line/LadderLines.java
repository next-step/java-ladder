package nextstep.ladder.domain.line;

import nextstep.ladder.domain.user.User;

import java.util.List;
import java.util.Map;

public class LadderLines {

    private List<LadderLine> ladders;

    public LadderLines(List<LadderLine> ladders) {
        this.ladders = ladders;
    }

    public Map<User, Integer> goDownALadder(Map<User, Integer> ladderResult) {
        for (User user : ladderResult.keySet()) {
            int position = ladderResult.get(user);
            position = caculatePosition(position);
            ladderResult.put(user, position);
        }
        return ladderResult;
    }

    private int caculatePosition(int position) {
        int finalPosition = position;
        for (LadderLine ladderLine : ladders) {
            finalPosition = ladderLine.ladderPlayCondition(finalPosition);
        }
        return finalPosition;
    }

    public LadderLine getLine(int index) {
        return ladders.get(index);
    }


    public int size() {
        return ladders.size();
    }

}
