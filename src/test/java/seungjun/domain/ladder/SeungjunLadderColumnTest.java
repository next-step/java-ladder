package seungjun.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seungjun.ladder.SeungjunLadderColumn;
import ladder.LadderConnection;

import static org.assertj.core.api.Assertions.assertThat;

public class SeungjunLadderColumnTest {
    @Test
    @DisplayName("[LadderColumn.connectedColumnIndex()] -> 인덱스 3 컬럼이 좌측 연결 컬럼일 때 -> 연결되는 컬럼은 2임")
    public void leftTest() {
        SeungjunLadderColumn column = new SeungjunLadderColumn(3, LadderConnection.LEFT);
        assertThat(column.connectedColumnIndex()).isEqualTo(2);
    }
}
