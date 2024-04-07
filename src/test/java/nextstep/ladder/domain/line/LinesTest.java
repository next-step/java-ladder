package nextstep.ladder.domain.line;

import static nextstep.ladder.domain.line.LadderConnectOrder.createLadderConnectOrders;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.error.exception.LadderHeightSizeException;
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
        List<LadderConnectOrder> ladderConnectOrders = new ArrayList<>();
        ladderConnectOrders.add(new LadderConnectOrder(List.of(false)));

        assertThatThrownBy(() -> new Lines(0, ladderConnectOrders))
            .isInstanceOf(LadderHeightSizeException.class)
            .hasMessage("사다리의 높이는 0보다 커야 합니다 입력값: 0");
    }

    @Test
    void 사용자의_당첨결과_인덱스를_조회해야_한다() {
        List<LadderConnectOrder> ladderConnectOrders = new ArrayList<>();
        ladderConnectOrders.add(new LadderConnectOrder(List.of(false, true))); // |    |----|
        ladderConnectOrders.add(new LadderConnectOrder(List.of(true, false))); // |----|    |
        ladderConnectOrders.add(new LadderConnectOrder(List.of(false, false)));// |    |    |

        Lines sutLines = new Lines(3, ladderConnectOrders);

        assertThat(sutLines.findUserResultIndex(1)).isEqualTo(2);
    }
}
