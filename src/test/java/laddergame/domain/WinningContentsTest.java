package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static laddergame.utilForTest.WinningContentsUtilForTest.newWinningContents;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningContentsTest {
    @Nested
    @DisplayName("WinningContents 인스턴스 생성 테스트")
    class InstanceCreationTest {
        @Test
        @DisplayName("인스턴스 생성시 winningContents의 크기가 MIN_NUMBER_OF_PLAYERS_AND_WINNING_CONTENTS보다 작은 경우 IllegalArgumentException이 발생한다.")
        void testWrongSizeOfPlayers() {
            List<WinningContent> winningContents = List.of(new WinningContent("1000"));
            assertThatThrownBy(() -> new WinningContents(winningContents))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("findWinningContentByIndex(): WinningContents.winningContents 중 전달된 index 순서에 해당하는 winningContent를 반환한다.")
    void testFindWinningContentByIndex() {
        WinningContent firstWinningContent = new WinningContent("a");
        WinningContent secondWinningContent = new WinningContent("b");
        WinningContents winningContents = newWinningContents(firstWinningContent, secondWinningContent);

        assertThat(winningContents.findWinningContentByIndex(0)).isEqualTo(firstWinningContent);
        assertThat(winningContents.findWinningContentByIndex(1)).isEqualTo(secondWinningContent);
    }

    @Test
    @DisplayName("numberOfWinningContents(): WinningContents.winningContents의 크기를 반환한다.")
    void testNumberOfWinningContents() {
        WinningContents winningContents = newWinningContents("a", "b", "c");
        assertThat(winningContents.numberOfWinningContents()).isEqualTo(3);
    }
}
