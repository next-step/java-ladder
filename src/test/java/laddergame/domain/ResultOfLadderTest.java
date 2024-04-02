package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultOfLadderTest {
    @Test
    @DisplayName("findResultByIndex(): results 중 전달된 index 순서에 해당하는 요소를 반환한다. ")
    void testFindWinningContentByIndex() {
        WinningContent winningContentA = WinningContent.valueOf("a");
        WinningContent winningContentB = WinningContent.valueOf("b");
        WinningContent winningContentC = WinningContent.valueOf("c");

        ResultOfLadder resultOfLadder = ResultOfLadder.valueOf(List.of(winningContentA, winningContentB, winningContentC));

        assertThat(resultOfLadder.findResultByIndex(1)).isEqualTo(winningContentB);

    }
}