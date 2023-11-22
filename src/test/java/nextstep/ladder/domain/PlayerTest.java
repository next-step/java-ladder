package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.AxisX;
import nextstep.ladder.domain.wrapper.AxisY;
import nextstep.ladder.domain.wrapper.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @DisplayName("이름을 가진 Player를 생성하고, x,y축 값을 초기화 한다.")
    @Test
    void createPlayer() {
        // given
        Name name = new Name("홍길동");
        AxisX axisX = new AxisX(0);
        AxisY axisY = new AxisY(0);
        assertThat(new Player(name, axisX, axisY)).isEqualTo(new Player(name, axisX, axisY));
    }
}
