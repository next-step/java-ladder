package nextstep.ladder.domain;

import nextstep.ladder.strategy.RandomConnectStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("플레이어의 수를 인자로 받아 사다리 라인을 생성한다.")
    public void create() throws Exception {
        Line line = new Line(4, new RandomConnectStrategy());
        assertThat(line.points()).hasSize(4);
    }
}
