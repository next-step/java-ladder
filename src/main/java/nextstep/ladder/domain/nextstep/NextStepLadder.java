package nextstep.ladder.domain.nextstep;

import nextstep.ladder.domain.GameResult;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.engine.Ladder;
import nextstep.ladder.domain.engine.Line;

import java.util.Iterator;
import java.util.List;

public class NextStepLadder implements Ladder, Iterable<Line> {

    private final List<Line> ladder;

    public NextStepLadder(List<Line> ladder) {
        this.ladder = List.copyOf(ladder);
    }

    @Override
    public GameResult run(Participants participants, LadderResult result) {
        GameResult gameResult = new GameResult();
        participants.forEach(name -> {
            int index = calculateIndexOfResult(participants, name);
            gameResult.put(name, result.get(index));
        });
        return gameResult;
    }

    private int calculateIndexOfResult(Participants participants, String name) {
        int index = participants.indexOf(name);

        for (Line line : ladder) {
            index = line.move(index);
        }
        return index;
    }

    @Override
    public Iterator<Line> iterator() {
        return ladder.iterator();
    }
}
