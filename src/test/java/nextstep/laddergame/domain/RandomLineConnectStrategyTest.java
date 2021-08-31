package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RandomLineConnectStrategyTest {

    @DisplayName("사다리의 한 라인은 (참여자의 수 - 1) 만큼의 포인트를 갖는다.")
    @Test
    public void linePointsCountTest() {
        LineConnectStrategy lineConnectStrategy = RandomLineConnectStrategy.of(new Random(), 4);
        assertThat(lineConnectStrategy.getLineConnections())
                .hasSize(3);
    }

    @DisplayName("참여자 수는 2명 이상이다.")
    @Test
    public void countOfPlayerTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RandomLineConnectStrategy.of(new Random(), 1));
    }

}