package ladder;

import ladder.domain.VerticalLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VerticalLineTest {

    @Test
    @DisplayName("세로줄 생성 테스트")
    void verticalLineCreateTest(){
        VerticalLine verticalLine = new VerticalLine(1);
    }

    @Test
    @DisplayName("세로줄에 점 생성 테스트")
    void verticalLinePointsTest(){
        VerticalLine verticalLine = new VerticalLine(1);
        verticalLine.addPoint(1, 2);
        verticalLine.addPoint(2, 2);

        assertThat(verticalLine.getPointCount()).isEqualTo(2);
    }
}
