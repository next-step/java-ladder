package nextstep.ladder.domain.line;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LadderConnectOrderTest {

    @Test
    void LadderConnectOrder는_사람수보다_한_개_적은_숫자의_크기를_가진다() {
        List<Boolean> sutLadderConnectOrder = LadderConnectOrder.createLadderConnectOrder(5);

        assertThat(sutLadderConnectOrder).hasSize(4);
    }

    @Test
    void LadderConnectOrders는_사다리높이만큼_개수를_가져야_한다() {
        List<LadderConnectOrder> sutLadderConnectOrder = LadderConnectOrder.createLadderConnectOrders(
            5, 4);

        assertThat(sutLadderConnectOrder).hasSize(5);
    }

    @Test
    void connectLadder를_수행한뒤_생성한_Points의_크기와_LadderConnectOrder의_크기는_동일하다() {
        LadderConnectOrder sutLadderConnectOrder = new LadderConnectOrder(
            LadderConnectOrder.createLadderConnectOrder(3));

        List<Point> points = sutLadderConnectOrder.connectLadder();

        assertThat(points.size()).isEqualTo(2);
    }
}
