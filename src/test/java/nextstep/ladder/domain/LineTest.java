package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @DisplayName("플레이어 수 만큼 지점을 가진 한 라인을 생성한다")
    @Test
    void creatLineTest() {
        Line line = new Line(5);
        assertThat(line.pointSize()).isEqualTo(5);
    }

    @DisplayName("플레이어가 2명 미만이라면 예외를 발생시킨다")
    @Test
    void createLineExceptionTest() {
        assertThatThrownBy(() -> new Line(1)).isInstanceOf(IllegalArgumentException.class);
    }
}
