package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VerticalLineTest {

    @Test
    @DisplayName("세로줄 생성 테스트")
    void verticalLineCreateTest(){
        VerticalLine verticalLine = new VerticalLine(0, 5);
    }

    @Test
    @DisplayName("세로줄에 점 생성 테스트")
    void verticalLinePointsTest(){
        VerticalLine verticalLine = new VerticalLine(0, 5);
        assertThat(verticalLine.getPoints().size()).isEqualTo(5);
    }
}
