package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import ladder.TestLinkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("link 메소드는 Line 객체가 가지고 있는 Point 객체들을 연결한다.")
    void link() {
        Line line = new Line(new PositiveInt(0), new PositiveInt(5));
        line.link(new TestLinkStrategy());

        assertThat(line.getAllIsLinked()).isEqualTo(List.of(true, false, true, false, false));
    }

    @Test
    @DisplayName("move 메소드는 Point의 연결 여부에 따라 다음 컬럼 위치를 계산한다.")
    void move() {
        Line line = new Line(new PositiveInt(0), new PositiveInt(5));
        line.link(new TestLinkStrategy());

        assertThat(line.move(1)).isEqualTo(0);
    }

    @Test
    @DisplayName("getAllIsLinked 메소드는 특정 Point의 연결 여부를 반환한다.")
    void isLinkedPoint() {
        Line line = new Line(new PositiveInt(0), new PositiveInt(5));
        line.link(new TestLinkStrategy());

        assertThat(line.getAllIsLinked()).isEqualTo(List.of(true, false, true, false, false));
    }
}