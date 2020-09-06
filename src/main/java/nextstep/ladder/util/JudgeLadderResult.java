package nextstep.ladder.util;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderPositionBoard;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Users;

import java.util.List;
import java.util.stream.IntStream;

public class JudgeLadderResult {

    private Ladder ladder;

    private final LadderPositionBoard ladderPositionBoard;

    private JudgeLadderResult(Ladder ladder, LadderPositionBoard ladderPositionBoard) {
        this.ladder = ladder;
        this.ladderPositionBoard = ladderPositionBoard;
    }

    public static JudgeLadderResult newInstance(Ladder ladder, Users users) {
        LadderPositionBoard ladderPositionBoard = LadderPositionBoard.create(users);
        return new JudgeLadderResult(ladder, ladderPositionBoard);
    }

    public LadderPositionBoard judge() {
        List<Line> ladder = this.ladder.getLadder();

        for(Line line : ladder) {
            judgePoint(line);
        }

        return ladderPositionBoard;
    }

    private void judgePoint(Line line) {
        List<Boolean> points = line.getPoints();

        for(int i = 0; i < points.size(); i++){
            switchPosition(line.isPoint(i),i);
        }
    }

    private void switchPosition(boolean isExistBridge, int point) {
        if(isExistBridge) {
            ladderPositionBoard.switchPosition(point);
        }
    }
}
