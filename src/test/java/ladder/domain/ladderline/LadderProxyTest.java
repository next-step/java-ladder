package ladder.domain.ladderline;

import ladder.RandomTestUtils;
import ladder.common.PositiveNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderProxyTest {

    private LadderLines ladder;

    @BeforeEach
    void setup() {
        //  a     b     c     d     e
        //  |-----|     |-----|     |
        //  |-----|     |-----|     |
        //  1     2     3     4     5

        List<LadderLine> ladderLines = Arrays.asList(LadderProxy.createLadderLine(RandomTestUtils.TRUE, PositiveNumber.of(5)),
                LadderProxy.createLadderLine(() -> true, PositiveNumber.of(5)));
        ladder = LadderProxy.createLadderLines(ladderLines);
    }

    @Test
    @DisplayName("0번 인덱스에서 출발인경우, 사다리 타기가 정상인지 확인한다")
    void moveLadder() {
        assertThat(LadderProxy.move(ladder, 0)).isEqualTo(0);
    }

    @Test
    @DisplayName("1번 인덱스에서 출발인경우, 사다리 타기가 정상인지 확인한다")
    void moveLadder1() {
        assertThat(LadderProxy.move(ladder, 1)).isEqualTo(1);
    }

    @Test
    @DisplayName("2번 인덱스에서 출발인경우, 사다리 타기가 정상인지 확인한다")
    void moveLadder2() {
        assertThat(LadderProxy.move(ladder, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("3번 인덱스에서 출발인경우, 사다리 타기가 정상인지 확인한다")
    void moveLadder3() {
        assertThat(LadderProxy.move(ladder, 3)).isEqualTo(3);
    }

    @Test
    @DisplayName("4번 인덱스에서 출발인경우, 사다리 타기가 정상인지 확인한다")
    void moveLadder4() {
        assertThat(LadderProxy.move(ladder, 4)).isEqualTo(4);
    }
}
