package ladder.ladder.domain;

import ladder.common.StubBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("높이와 참여자의 수로 사다리를 초기화 할 수 있다")
    @Test
    public void init() {
        Ladder ladder = Ladder.init(5, 5);
        assertThat(ladder.getLadder()).hasSize(5);
    }

    @DisplayName("시작위치의 인덱스를 입력하고 사다리를 타면 종료시 위치를 알 수 있다")
    @Test
    public void move() {
        Point point00 = StubBuilder.buildStubPoint(0, false, true);
        Point point01 = StubBuilder.buildStubPoint(1, true, false);
        Point point02 = StubBuilder.buildStubPoint(2, false, false);
        Point point10 = StubBuilder.buildStubPoint(0, false, true);
        Point point11 = StubBuilder.buildStubPoint(1, true, false);
        Point point12 = StubBuilder.buildStubPoint(2, false, false);

        LadderLine ladderLine1 = LadderLine.of(Arrays.asList(point00, point01, point02));
        LadderLine ladderLine2 = LadderLine.of(Arrays.asList(point10, point11, point12));
        Ladder ladder = Ladder.of(Arrays.asList(ladderLine1, ladderLine2));

        Index resultIndex = ladder.move(Index.of(0));

        assertThat(resultIndex).isEqualTo(Index.of(0));
    }

}
