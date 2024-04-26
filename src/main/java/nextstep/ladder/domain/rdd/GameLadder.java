package nextstep.ladder.domain.rdd;

import nextstep.ladder.interfaces.Ladder;
import nextstep.ladder.interfaces.LadderResult;
import nextstep.ladder.interfaces.Line;

import java.util.List;

public class GameLadder implements Ladder {
    private final int countOfPeople;
    private final List<Line> lines;

    public GameLadder(int countOfPeople, List<Line> lines) {
        this.countOfPeople = countOfPeople;
        this.lines = lines;
    }

    @Override
    public LadderResult game() {
        LadderResult ladderResult = new GameLadderResult();
        for (int i = 0; i < countOfPeople; i++) {
            ladderResult.add(move(i));
        }
        return ladderResult;
    }

    private int move(int position) {
        int result = position;
        for (Line line : lines) {
            result = line.move(result);
        }
        return result;
    }

    public int countOfLines() {
        return lines.size();
    }
}
