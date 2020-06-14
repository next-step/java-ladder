package ladder.domain.ladder;

import ladder.domain.ladder.ladderInfo.LineCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineCountTest {

    @Test
    @DisplayName("라인 카운트 생성 테스트")
    void lineCountCreateTest() {
        int playerCount = 4;
        LineCount createLineCount = LineCount.inputLineCount(playerCount);
        assertThat(createLineCount.getLineCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("라인 카운트 음수 생성 테스트")
    void lineCountCreateFailTest() {
        int lineCount = -1;
        assertThatThrownBy(() ->  LineCount.inputLineCount(lineCount))
                .hasMessageMatching("라인의 갯수는 2 보다 작을 수 없습니다.");
    }
}
