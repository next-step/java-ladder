package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @DisplayName("0명이거나 음수를 입력했을 때, IllegalArgumentException을 반환한다 ")
    @Test
    void zeroOrNegative() {
        assertThatThrownBy(() -> new Line(0, true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자는 1명 이상이어야 합니다.");
    }

    @DisplayName("Line 객체를 초기화했을 때, 앞 부분이 가로선이 생겼다면 그 다음 부분은 공백이 된다")
    @Test
    void horizonRule() {
        Line line = new Line(3, true);

        assertThat(line.getPoints().get(4)
                .equals(line.getPoints().get(5)))
                .isFalse();
    }

    @DisplayName("참가자수(n)에 따라 Line의 사이즈는 (n - 1) * 5 가 된다")
    @Test
    void initLine() {
        assertThat(new Line(3, true).size()).isEqualTo(10);
    }

}
