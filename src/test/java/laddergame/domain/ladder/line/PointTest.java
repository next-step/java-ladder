package laddergame.domain.ladder.line;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    private Point point;
    private Point linkPoint = new Point();


    @BeforeEach
    void setUp() {
        point = new Point();
    }

    @Test
    @DisplayName("포인트 생성시엔 아무와도 연결되지 않는다.")
    void 포인트를생성() {
        assertThat(point).isEqualTo(new Point());
        assertThat(point.isLinked()).isFalse();
    }

    @Test
    @DisplayName("다른 포인트와 연결한다.")
    void 링크를생성() {
        point.link(linkPoint);

        assertThat(point.isLinked()).isTrue();
    }

    @Test
    @DisplayName("특정 포인트와 연결되어있는지 확인한다.")
    void 특정포인트와연결되어있는지확인() {
        Point anotherPoint = new Point();
        point.link(linkPoint);

        assertThat(point.isLinkedWith(anotherPoint)).isFalse();
        assertThat(point.isLinkedWith(linkPoint)).isTrue();
    }
}
