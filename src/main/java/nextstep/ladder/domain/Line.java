package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    static final int PLAYERS_MIN_COUNT = 2;

    private final List<Point> points;

    public Line(int countOfPerson) {
        if (countOfPerson < PLAYERS_MIN_COUNT) {
            throw new IllegalArgumentException("인원은 적어도 2명 이상이어야 합니다: " + countOfPerson);
        }
        points = new ArrayList<>(4);
        for (int i = 0; i < countOfPerson; i++) {
            points.add(new Point(i));
        }
    }

    public int getPointsSize() {
        return points.size();
    }

    public void createBridge(int createAt) {
        if (createAt >= points.size() - 1 || createAt < 0) {
            throw new IllegalStateException("해당 지점에 사다리를 지을 수 없습니다: " + createAt);
        }
        if (!points.get(createAt).equals(new Point(createAt))) {
            throw new IllegalStateException("해당 지점에 사다리가 존재합니다: " + createAt);
        }
        points.set(createAt, new Point(createAt + 1));
        points.set(createAt + 1, new Point(createAt));
    }

    public void createBridge(List<Integer> createAtList) {
        createAtList.forEach(this::createBridge);
    }

    public Point moveFrom(int from) {
        return points.get(from);
    }

    public Player movePlayerToNewPoint(Player player) {
        return IntStream.range(0, points.size())
                .filter(i -> player.isPlayerInPosition(new Point(i)))
                .mapToObj(i -> player.move(moveFrom(i)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("플레이어의 Point값이 잘못되었습니다."));
    }
}
