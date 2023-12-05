package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderColumnTest {
    @Test
    @DisplayName("[LadderColumn.connectedColumnIndex()] -> 인덱스 3 컬럼이 좌측 연결 컬럼일 때 -> 연결되는 컬럼은 2임")
    public void leftTest() {
        LadderColumn column = new LadderColumn(3, LadderConnection.LEFT);
        assertThat(column.connectedColumnIndex()).isEqualTo(2);
    }
}
