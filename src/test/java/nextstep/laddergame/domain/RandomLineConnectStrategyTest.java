package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLineConnectStrategyTest {

    @DisplayName("사다리의 한 라인은 (참여자의 수 - 1) 만큼의 포인트를 갖는다.")
    @Test
    public void linePointsCountTest() {
        LineConnectStrategy lineConnectStrategy = new RandomLineConnectStrategy(new Random(), 4);
        assertThat(lineConnectStrategy.getLineConnections())
                .hasSize(3);
    }

}