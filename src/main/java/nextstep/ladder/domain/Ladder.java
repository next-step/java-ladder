package nextstep.ladder.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Ladder {

    private final List<LadderLine> ladderLines;

    public Ladder(final Players players, final Height height) {
        this.ladderLines = height.intStream()
                .mapToObj(i -> LadderLine.init(players.count()))
                .collect(Collectors.toList());
    }

    public Ladder(final List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public List<List<Boolean>> getLadderBarStatus() {
        return ladderLines.stream()
                .map(LadderLine::getLineBarStatus)
                .collect(Collectors.toList());
    }

    public int startMoving(int startPosition) {
        AtomicInteger position = new AtomicInteger(startPosition);
        ladderLines.forEach(ladderLine -> {
            int nextPosition = ladderLine.move(position.get());
            position.set(nextPosition);
        });
        return position.get();
    }

}
