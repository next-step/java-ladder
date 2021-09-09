package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static nextstep.laddergame.domain.LineConnection.CONNECTED;
import static nextstep.laddergame.domain.LineConnection.UNCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("사다리는 입력 받은 높이 만큼의 라인을 갖는다.")
    @Test
    public void ladderHeightTest() {
        int height = 5;
        Players players = Players.of(Arrays.asList("abc", "def"));
        LadderHeights ladderHeights = LadderHeights.of(height);
        Ladder ladder = Ladder.of(players, ladderHeights);
        assertThat(ladder.height())
                .isEqualTo(height);
    }

    @DisplayName("사다리 시작 포지션으로 결과 포지션을 알 수 있다.")
    @Test
    public void ladderResultPositionTest() {
        Players players = Players.of(Arrays.asList("a", "b", "c", "d"));
        PlayResults playResults = PlayResults.with(players.size(), Arrays.asList("A", "B", "C", "D"));
        Ladder ladder = createLadder();
        LadderResults ladderResults = ladder.getResults(players, playResults);
        /*
         *  a     b     c     d
         *  |-----|     |-----|
         *  |     |-----|     |
         *  |     |     |-----|
         *  A     B     C     D
         */
        assertThat(ladderResults.getResult("a")).isEqualTo("D");
        assertThat(ladderResults.getResult("b")).isEqualTo("A");
        assertThat(ladderResults.getResult("c")).isEqualTo("C");
        assertThat(ladderResults.getResult("d")).isEqualTo("B");
    }

    private Ladder createLadder() {
        Line first = Line.of(() -> Arrays.asList(CONNECTED, UNCONNECTED, CONNECTED));
        Line second = Line.of(() -> Arrays.asList(UNCONNECTED, CONNECTED, UNCONNECTED));
        Line third = Line.of(() -> Arrays.asList(UNCONNECTED, UNCONNECTED, CONNECTED));
        return new Ladder(Arrays.asList(first, second, third));
    }

}