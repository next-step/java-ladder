package ladder.domain.core.line.move;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @DisplayName("자기 자신과 연결되는 지 확")
    @Test
    void linkPoint1Test() {
        Point p1 = new Point(1);

        assertThat(p1.isEmptyNextPoint()).isTrue();

        p1.link(p1);

        assertThat(p1.linkingPoint()).isEqualTo(Point.empty());
    }

    @DisplayName("2개의 점이 서로 연결되어 있는지 확인")
    @Test
    void linkPoint2Test() {
        Point p1 = new Point(1);
        Point p2 = new Point(2);

        assertThat(p1.isEmptyNextPoint()).isTrue();
        assertThat(p2.isEmptyNextPoint()).isTrue();

        p1.link(p2);

        assertThat(p1.linkingPoint()).isEqualTo(p2);
        assertThat(p2.linkingPoint()).isEqualTo(p1);
    }


    @DisplayName("3개의 점이 서로 연인결될때 1개의 링크가 생성됬는지 확인")
    @Test
    void linkPoint3Test() {
        Point p1 = new Point(1);
        Point p2 = new Point(2);
        Point p3 = new Point(3);

        assertThat(p1.isEmptyNextPoint()).isTrue();
        assertThat(p2.isEmptyNextPoint()).isTrue();
        assertThat(p3.isEmptyNextPoint()).isTrue();

        p1.link(p2);
        p2.link(p3);

        assertThat(p1.linkingPoint()).isEqualTo(p2);
        assertThat(p2.linkingPoint()).isEqualTo(p1);
        assertThat(p3.linkingPoint()).isEqualTo(Point.empty());
    }

    @DisplayName("4개의 점이 서로 연결될때 2개의 링크가 생성되는지 확인")
    @Test
    void linkPoint4Test() {
        Point p1 = new Point(1);
        Point p2 = new Point(2);
        Point p3 = new Point(3);
        Point p4 = new Point(4);

        assertThat(p1.isEmptyNextPoint()).isTrue();
        assertThat(p2.isEmptyNextPoint()).isTrue();
        assertThat(p3.isEmptyNextPoint()).isTrue();
        assertThat(p4.isEmptyNextPoint()).isTrue();

        p1.link(p2);
        p2.link(p3);
        p3.link(p4);

        assertThat(p1.linkingPoint()).isEqualTo(p2);
        assertThat(p3.linkingPoint()).isEqualTo(p4);
    }
}
