package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultOfLadderTest {
    @Test
    @DisplayName("findWinningContentByIndex(): winningContents 중 전달된 index 순서에 해당하는 winningContent를 반환한다. ")
    void testFindWinningContentByIndex() {
        WinningContent winningContentA = WinningContent.valueOf("a");
        WinningContent winningContentB = WinningContent.valueOf("b");
        WinningContent winningContentC = WinningContent.valueOf("c");

        ResultOfLadder resultOfLadder = ResultOfLadder.valueOf(List.of(winningContentA, winningContentB, winningContentC));

        assertThat(resultOfLadder.findWinningContentByIndex(1)).isEqualTo(winningContentB);

    }
}