package nextstep.ladder.domain.lines;

import static nextstep.ladder.domain.ladderconnectorder.impl.RandomLadderConnectOrder.createLadderConnectOrders;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.domain.ladderconnectorder.LadderConnectOrder;
import nextstep.ladder.error.exception.LadderHeightSizeException;
import nextstep.ladder.domain.ladderconnectorder.impl.RandomLadderConnectOrder;
import org.junit.jupiter.api.Test;

class LinesTest {

    @Test
    void 사다리높이와_LadderConnectOrder가_전달될때_높이만큼_라인이_생겨야_한다() {
        int height = 3;
        Lines sutLines = new Lines(height, createLadderConnectOrders(height, 4));

        assertThat(sutLines.size()).isEqualTo(3);
    }

    @Test
    void 사다리_높이가_1보다_작을_경우_예외가_발생해야_한다() {
        List<LadderConnectOrder> randomLadderConnectOrders = new ArrayList<>();
        randomLadderConnectOrders.add(new RandomLadderConnectOrder(List.of(false)));

        assertThatThrownBy(() -> new Lines(0, randomLadderConnectOrders))
            .isInstanceOf(LadderHeightSizeException.class)
            .hasMessage("사다리의 높이는 0보다 커야 합니다 입력값: 0");
    }

    @Test
    void 사용자의_당첨결과_인덱스를_조회해야_한다() {
        List<LadderConnectOrder> randomLadderConnectOrders = new ArrayList<>();
        randomLadderConnectOrders.add(new RandomLadderConnectOrder(List.of(false, true))); // |    |----|
        randomLadderConnectOrders.add(new RandomLadderConnectOrder(List.of(true, false))); // |----|    |
        randomLadderConnectOrders.add(new RandomLadderConnectOrder(List.of(false, false)));// |    |    |

        Lines sutLines = new Lines(3, randomLadderConnectOrders);

        assertThat(sutLines.findUserResultIndex(1)).isEqualTo(2);
    }
}
