package ladder.domain.core.line.move;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovablePointsLinkTest {
    @DisplayName("Line 생성시 무조건 링크를 생성하는 경우")
    @Test
    void allLink() {
        MovablePoints line = MovablePoints.of(()-> true, 5);

        assertThat(line.getPointByIndex(0).linkingPoint()).isEqualTo(line.getPointByIndex(1));
        assertThat(line.getPointByIndex(2).linkingPoint()).isEqualTo(line.getPointByIndex(3));
        assertThat(line.getPointByIndex(4).linkingPoint()).isEqualTo(Point.empty());
        assertThat(line.collectLinkState()).containsExactly(true, false, true, false, false);
    }

    @DisplayName("Line 생성시 무조건 링크를 생성하지 않는 경우")
    @Test
    void allNotLink() {
        MovablePoints line = MovablePoints.of(()-> false, 5);

        assertThat(line.getPointByIndex(0).linkingPoint()).isEqualTo(Point.empty());
        assertThat(line.getPointByIndex(1).linkingPoint()).isEqualTo(Point.empty());
        assertThat(line.getPointByIndex(2).linkingPoint()).isEqualTo(Point.empty());
        assertThat(line.getPointByIndex(3).linkingPoint()).isEqualTo(Point.empty());
        assertThat(line.getPointByIndex(4).linkingPoint()).isEqualTo(Point.empty());
        assertThat(line.collectLinkState()).containsExactly(false, false, false, false, false);
    }

}