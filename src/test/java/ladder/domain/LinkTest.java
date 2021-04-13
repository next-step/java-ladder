package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkTest {

    private Point point = new Point();
    private Point linkPoint = new Point();
    private Link<Point, Point> link;

    @BeforeEach
    void setUp() {
        link = new Link<>();
        link.pair(point);
    }

    @Test
    void 두포인트의한페어생성() {
        assertThat(link.isNow(point)).isTrue();
    }

    @Test
    void 다음포인트지정() {
        link.pair(linkPoint);

        assertThat(link.isNext(linkPoint)).isTrue();
        assertThat(link.isNext(point)).isFalse();
        assertThat(link.isNow(point)).isTrue();
    }

    @Test
    void 페어를연결() {
        link.pair(linkPoint);
        link.link(() -> true);

        assertThat(point.isLinkedWith(linkPoint)).isTrue();
        assertThat(linkPoint.isLinkedWith(point)).isTrue();
    }

    @Test
    void 페어를연결하지않음() {
        link.pair(linkPoint);
        link.link(() -> false);

        assertThat(point.isLinkedWith(linkPoint)).isFalse();
    }

    @Test
    void 연결된포인트는_새로연결되지않음() {
        point.link(linkPoint);
        Point pairPoint = new Point();
        link.pair(pairPoint);
        link.link(() -> true);

        assertThat(point.isLinkedWith(linkPoint)).isTrue();
        assertThat(point.isLinkedWith(pairPoint)).isFalse();
    }
}
