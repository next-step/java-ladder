package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningContentsTest {
    @Nested
    @DisplayName("WinningContents 인스턴스 생성 테스트")
    class InstanceCreationTest {
        @Test
        @DisplayName("인스턴스 생성시 winningContents의 크기가 MIN_NUMBER_OF_PLAYERS_AND_WINNING_CONTENTS보다 작은 경우 IllegalArgumentException이 발생한다.")
        void testWrongSizeOfPlayers() {
            List<WinningContent> winningContents = List.of(WinningContent.valueOf("1000"));
            assertThatThrownBy(() -> WinningContents.valueOf(winningContents))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("numberOfWinningContents(): WinningContents.winningContents의 크기를 반환한다.")
    void testNumberOfWinningContents() {
        WinningContents winningContents = WinningContents.newWinningContents("a", "b", "c");
        assertThat(winningContents.numberOfWinningContents()).isEqualTo(3);
    }
}