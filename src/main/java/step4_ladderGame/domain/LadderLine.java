package step4_ladderGame.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LadderLine {

    private final List<Stair> stairs;

    private LadderLine(List<Stair> Stair, int playerCount) {
        if (Stair.size() != playerCount) {
            throw new IllegalArgumentException("사다리 라인 수와 플레이어 수가 맞지 않습니다.");
        }
        this.stairs = Stair;
    }

    public static LadderLine of(int playerCount, RandomPointStrategy randomCreateStrategy) {
        List<Point> points = ((CreatePointStrategy) randomCreateStrategy).createPoint(playerCount);
        List<Stair> stairs = IntStream.range(0, playerCount)
                .mapToObj(index -> Stair.of(Position.of(index), points.get(index)))
                .collect(toList());
        return new LadderLine(stairs, playerCount);
    }

    public int size() {
        return stairs.size();
    }

}
