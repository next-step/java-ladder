package nextstep.ladder.domain.lines;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nextstep.ladder.domain.ladderconnectorder.LadderConnectOrder;
import nextstep.ladder.domain.ladderconnectorder.impl.RandomLadderConnectOrder;
import nextstep.ladder.domain.lines.point.Point;
import org.junit.jupiter.api.Test;

class RandomLadderConnectOrderTest {

    @Test
    void LadderConnectOrder는_사람수보다_한_개_적은_숫자의_크기를_가진다() {
        List<Boolean> sutLadderConnectOrder = RandomLadderConnectOrder.createLadderConnectOrder(5);

        assertThat(sutLadderConnectOrder).hasSize(4);
    }

    @Test
    void LadderConnectOrders는_사다리높이만큼_개수를_가져야_한다() {
        List<LadderConnectOrder> sutRandomLadderConnectOrder = RandomLadderConnectOrder.createLadderConnectOrders(
            5, 4);

        assertThat(sutRandomLadderConnectOrder).hasSize(5);
    }

    @Test
    void connectLadder를_수행한뒤_생성한_Points의_크기와_LadderConnectOrder의_크기는_동일하다() {
        LadderConnectOrder sutRandomLadderConnectOrder = new RandomLadderConnectOrder(
            RandomLadderConnectOrder.createLadderConnectOrder(3));

        List<Point> points = sutRandomLadderConnectOrder.connectLadder();

        assertThat(points.size()).isEqualTo(2);
    }
}
