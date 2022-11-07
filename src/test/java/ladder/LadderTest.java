package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    @DisplayName("가로 선이 없으면 처음 인덱스와 마지막 인덱스가 같다.")
    void test1() {
        Ladder ladder = new Ladder(1, 3, new FixedPointConnectStrategy(List.of(FALSE, FALSE)));
        assertThat(ladder.findFinalIndexOf(0)).isEqualTo(0);
        assertThat(ladder.findFinalIndexOf(1)).isEqualTo(1);
        assertThat(ladder.findFinalIndexOf(2)).isEqualTo(2);
    }

    @Test
    @DisplayName("가로선이 하나만 있는 경우, 0이 1로, 1이 0으로 바뀐다")
    void test2() {
        Ladder ladder = new Ladder(1, 2, new FixedPointConnectStrategy(List.of(TRUE)));
        assertThat(ladder.findFinalIndexOf(0)).isEqualTo(1);
        assertThat(ladder.findFinalIndexOf(1)).isEqualTo(0);
    }

}
