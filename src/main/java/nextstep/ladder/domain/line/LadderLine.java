package nextstep.ladder.domain.line;

import nextstep.ladder.domain.user.User;

import java.util.List;
import java.util.Map;

public class LadderLine {

    private List<Line> ladders;

    public LadderLine(List<Line> ladders) {
        this.ladders = ladders;
    }

    public Map<User, Integer> goDownALadder(Map<User, Integer> ladderResult) {
        for (User user : ladderResult.keySet()) {
            int position = ladderResult.get(user);
            position = caculatePosition(ladders, position);
            ladderResult.put(user, position);
        }
        return ladderResult;
    }

    private int caculatePosition(List<Line> ladders, int position) {
        for (int i = 0; i < ladders.size(); i++) {
            Line line = ladders.get(i);
            position = line.ladderPlayCondition(position);
        }
        return position;
    }

    public Line getLine(int index) {
        return ladders.get(index);
    }

    public int size() {
        return ladders.size();
    }

}
