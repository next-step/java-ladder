package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HorizontalLineTest {
    @DisplayName("입력한 수 만큼의 길이의 가로 라인이 만들어진다.")
    @Test
    void lineSize() {
        int size = 3;
        HorizontalLine horizontalLine = HorizontalLine.of(size);
        assertThat(horizontalLine.size()).isEqualTo(size);
    }

    @DisplayName("마지막 포인트는 무조건 선이 없다.")
    @Test
    void lastIsFalse() {
        int size = 3;
        HorizontalLine horizontalLine = new HorizontalLine(size);
        horizontalLine.makeDirection(size - 1);
        assertThat(horizontalLine.getPoint(size - 1).hasRightDirection())
                .isFalse();
    }

    @DisplayName("연속으로 포인트에 선이 있을 수 없다.")
    @Test
    void notConsecutivePoint() {
        HorizontalLine horizontalLine = new HorizontalLine(3);
        horizontalLine.makeDirection(1);
        horizontalLine.makeDirection(2);

        assertThat(horizontalLine.getPoint(1).hasRightDirection()).isTrue();
        assertThat(horizontalLine.getPoint(2).hasRightDirection()).isFalse();
    }
}
