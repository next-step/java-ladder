package laddergame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.Participates;

public class LadderGame {

    public Ladder createLadder(Participates participates, int height) {
        List<Line> ladders = new ArrayList<>();
        int lineCount = participates.countParticipants() - 1;
        IntStream.range(0, height).forEach(i -> ladders.add(new Line(lineCount)));

        return new Ladder(ladders);

    }
}
