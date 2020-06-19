package ladder.domain.line;

import ladder.domain.direction.RandomDirectionSelectStrategy;
import ladder.domain.player.Players;
import ladder.domain.point.PointPainter;

import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderLinePainter {

    public LadderLines drawLines(Players players, LadderHeight ladderHeight) {
        validate(players, ladderHeight);

        int playersCount = players.size();
        PointPainter pointPainter = new PointPainter(new RandomDirectionSelectStrategy());

        return IntStream.range(0, ladderHeight.getHeight())
                .mapToObj(i -> new LadderLine(playersCount, pointPainter))
                .collect(collectingAndThen(toList(), LadderLines::new));
    }

    private void validate(Players players, LadderHeight ladderHeight) {
        Objects.requireNonNull(players, "players는 null일 수 없습니다.");
        Objects.requireNonNull(ladderHeight, "ladderHeight은 null일 수 없습니다.");
    }
}
