package ladder.domain.core.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovableLineLinkTest {
    @DisplayName("Line 생성시 무조건 링크를 생성하는 경우")
    @Test
    void allLink() {
        MovableLine line = MovableLine.create(()-> true, 5);

        assertThat(line.getPoint(0).linkingPoint()).isEqualTo(line.getPoint(1));
        assertThat(line.getPoint(2).linkingPoint()).isEqualTo(line.getPoint(3));
        assertThat(line.getPoint(4).linkingPoint()).isEqualTo(Point.empty());
    }

    @DisplayName("Line 생성시 무조건 링크를 생성하지 않는 경우")
    @Test
    void allNotLink() {
        MovableLine line = MovableLine.create(()-> false, 5);

        assertThat(line.getPoint(0).linkingPoint()).isEqualTo(Point.empty());
        assertThat(line.getPoint(1).linkingPoint()).isEqualTo(Point.empty());
        assertThat(line.getPoint(2).linkingPoint()).isEqualTo(Point.empty());
        assertThat(line.getPoint(3).linkingPoint()).isEqualTo(Point.empty());
        assertThat(line.getPoint(4).linkingPoint()).isEqualTo(Point.empty());
    }
}