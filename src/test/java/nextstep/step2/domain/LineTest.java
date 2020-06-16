package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("Line 테스트")
class LineTest {

    private int userCount = 4;
    private Line line = new Line(userCount);

    @DisplayName("라인 생성 확인")
    @Test
    void lineGenerateTest() {
        assertThatCode(() -> {
            new Line(userCount);
        }).doesNotThrowAnyException();
    }

    @DisplayName("정상적인 라인 확인")
    @Test
    void getPoints() {
        List<Boolean> points = line.getPoints();

        boolean beforeLine = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            if(beforeLine) {
                assertThat(points.get(i)).isFalse();
            }
            beforeLine = points.get(i);
        }
    }

    @DisplayName("라인 길이 확인")
    @Test
    void lineLengthTest() {
        assertThat(line.getPoints().size()).isEqualTo(userCount - 1);
    }


}
