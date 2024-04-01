package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("Line 객체를 초기화했을 때, 앞 부분이 가로선이 생겼다면 그 다음 부분은 공백이 된다")
    @Test
    void horizonRule() {
        assertThat(new Line(3, true).getPoints().get(4) //true
                .equals(new Line(3, false).getPoints().get(5))).isFalse(); //false

    }

    @DisplayName("참가자수(n)에 따라 Point는 (n - 1) * 5 만큼 생긴다")
    @Test
    void initLine() {
        assertThat(new Line(3, true).getPoints().size()).isEqualTo(10);
    }

}
