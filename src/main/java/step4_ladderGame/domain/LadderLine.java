package step4_ladderGame.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LadderLine {

    private final List<Stair> stairs;

    private LadderLine(List<Stair> stairs, int playerCount) {
        if (stairs.size() != playerCount) {
            throw new IllegalArgumentException("사다리 라인 수와 플레이어 수가 맞지 않습니다.");
        }
        this.stairs = stairs;
    }

    private LadderLine(List<Stair> stairs) {
        this.stairs = stairs;
    }

    public static LadderLine of(int playerCount, RandomPointStrategy randomCreateStrategy) {
        List<Point> points = ((CreatePointStrategy) randomCreateStrategy).createPoint(playerCount);
        List<Stair> stairs = IntStream.range(0, playerCount)
                .mapToObj(index -> Stair.of(Position.of(index), points.get(index)))
                .collect(toList());
        return new LadderLine(stairs, playerCount);
    }

    public static LadderLine of(List<Stair> stairs) {
        return new LadderLine(stairs);
    }


    public int size() {
        return stairs.size();
    }

    public Player move(Player player) {
        return stairs.stream()
                .filter(stair -> stair.isSamePosition(player.getPosition()))
                .map(stair -> player.move(stair.move()))
                .collect(toList()).get(0);
    }
}
