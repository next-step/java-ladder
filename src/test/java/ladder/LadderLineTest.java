package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    @Test
    @DisplayName("연결, 미연결, 연결")
    void test1() {
        LadderLine ladderLine = LadderLine.of(4, new FixedPointConnectStrategy(List.of(TRUE, FALSE, TRUE)));
        assertThat(ladderLine.isConnected(0, 1)).isTrue();
        assertThat(ladderLine.isConnected(1, 2)).isFalse();
        assertThat(ladderLine.isConnected(2, 3)).isTrue();
    }

}
