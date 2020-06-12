package ladder;

import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderLinePainter {

    public LadderLines drawLines(Players players, LadderHeight ladderHeight) {
        Objects.requireNonNull(players, "players는 null일 수 없습니다.");
        Objects.requireNonNull(ladderHeight, "ladderHeight은 null일 수 없습니다.");

        return IntStream.range(0, ladderHeight.getHeight())
                .mapToObj(i -> new LadderLine(players.size()))
                .collect(collectingAndThen(toList(), LadderLines::new));
    }
}
