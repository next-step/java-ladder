package ladder;

import ladder.domain.Bridge;
import ladder.domain.Ladder;
import ladder.generator.FixedBridgeGenerator;
import ladder.generator.RandomBridgeGenerator;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    public void 플레이어_수와_높이를_기반으로_사다리를_생성한다() {
        int players = 5;
        int height = 5;

        Ladder ladder = Ladder.generateLadder(players, height, new RandomBridgeGenerator());
        int actual = ladder.getLadderHeight();

        assertThat(actual).isEqualTo(height);
    }

    @Test
    public void 시작_위치를_입력하면_최종_도착지_위치를_반환한다() {
        int players = 3;
        int height = 3;

        Queue<Bridge> bridges = new LinkedList<>();
        bridges.offer(Bridge.CONNECTED);
        bridges.offer(Bridge.DISCONNECTED);
        bridges.offer(Bridge.DISCONNECTED);
        bridges.offer(Bridge.CONNECTED);
        bridges.offer(Bridge.CONNECTED);
        bridges.offer(Bridge.DISCONNECTED);

        Ladder ladder = Ladder.generateLadder(players, height, new FixedBridgeGenerator(bridges));
        assertThat(ladder.move(0)).isEqualTo(2);
        assertThat(ladder.move(1)).isEqualTo(1);
        assertThat(ladder.move(2)).isEqualTo(0);
    }

}
