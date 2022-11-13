package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import ladder.TestLinkStrategy;
import ladder.strategy.LinkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("link 메소드는 Line 객체가 가지고 있는 Point 객체들을 연결한다.")
    void link() {
        Line line = new Line(new PositiveInt(0), new PositiveInt(5));
        line.link(new TestLinkStrategy());

        assertThat(line.getPoints().stream()
            .filter(line::isLinkedPoint)
            .collect(Collectors.toList())).containsOnly(new Point(0, 0), new Point(0, 2));
    }

    @Test
    @DisplayName("move 메소드는 Point의 연결 여부에 따라 다음 컬럼 위치를 계산한다.")
    void move() {
        Line line = new Line(new PositiveInt(0), new PositiveInt(5));
        line.link(new TestLinkStrategy());

        assertThat(line.move(1)).isEqualTo(0);
    }

    @Test
    @DisplayName("isLinkedPoint 메소드는 특정 Point의 연결 여부를 반환한다.")
    void isLinkedPoint() {
        Line line = new Line(new PositiveInt(0), new PositiveInt(5));
        line.link(new TestLinkStrategy());

        assertThat(line.isLinkedPoint(new Point(0, 0))).isTrue();
    }
}