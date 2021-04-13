/*
 * 사다리의 가로줄을 의미하는 클래스
 * */
package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
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
        Link<Point, Point> link = new Link<>();
        points.stream().forEach(point -> {
            link.pair(point);
            link.link(strategy);
        });
    }
}
