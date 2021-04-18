/*
 * 사다리의 가로줄을 의미하는 클래스
 * */
package laddergame.domain.ladder.line;

import laddergame.domain.ladder.LadderStrategy;
import laddergame.domain.ladder.Size;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

public class Line {
    private static final int CHECK_INDEX = 1;
    private List<Point> points = new ArrayList<>();

    public Line(Size size) {
        size.widthRange()
                .forEach(i -> {
                    points.add(new Point());
                });
    }

    /* 테스트용 생성자 */
    public Line(List<Point> points) {
        this.points = points;
    }

    /* 전략에 따라서 라인의 포인트들을 연결한다. */
    public void connect(LadderStrategy strategy) {
        PointLink link = new PointLink();
        points.forEach(point -> {
            link.pair(point);
            link.link(strategy);
        });
    }

    public List<Boolean> isConnect() {
        PointLink link = new PointLink();
        return points.stream().map(point -> {
            link.pair(point);
            return link.isLink();
        }).collect(toCollection(ArrayList::new));
    }

    public int moveOne(int index) {
        if (index > 0 && checkBefore(index)) {
            return index - CHECK_INDEX;
        }
        if (index < points.size() - CHECK_INDEX && checkAfter(index)) {
            return index + CHECK_INDEX;
        }
        return index;
    }

    private boolean checkBefore(int index) {
        PointLink link = new PointLink();
        link.pair(points.get(index - CHECK_INDEX));
        link.pair(points.get(index));
        return link.isLink();
    }

    private boolean checkAfter(int index) {
        PointLink link = new PointLink();
        link.pair(points.get(index));
        link.pair(points.get(index + CHECK_INDEX));
        return link.isLink();
    }
}
