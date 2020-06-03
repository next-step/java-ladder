package nextstep.ladder.domain.factory;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class LineFactory {

    private LineFactory() { }

    public static Line create(int countOfPlayer, PointStrategy pointStrategy) {
        validateCount(countOfPlayer);
        validatePointStrategy(pointStrategy);

        List<Point> points = new ArrayList<>(Arrays.asList(Point.first(pointStrategy)));
        for (int i = 1; i < countOfPlayer - 1; i++) {
            Point prevPoint = points.get(i - 1);
            points.add(prevPoint.next(pointStrategy));
        }

        return Line.newInstance(points);
    }

    private static void validateCount(int countOfPlayer) {
        if (countOfPlayer < 2) {
            throw new IllegalArgumentException("참여자 인원은 최소 2명 이상이어야 합니다.");
        }
    }

    private static void validatePointStrategy(PointStrategy pointStrategy) {
        if (pointStrategy == null) {
            throw new IllegalArgumentException("라인 생성 전략이 존재하지 않습니다.");
        }
    }
}
