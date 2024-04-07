package laddergame.domain;

import laddergame.utilForTest.PlayersUtilForTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static laddergame.utilForTest.WinningContentsUtilForTest.newWinningContents;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersAndWinningContentsTest {
    @Test
    @DisplayName("PlayersAndWinningContents 인스턴스 생성시 players.players와 WinningContents.winningContents의 크기가 다르면 IllegalArgumentException이 발생한다.")
    void testInstanceCreation() {
        assertThatThrownBy(() -> new PlayersAndWinningContents(PlayersUtilForTest.newPlayers("a", "b", "c"), newWinningContents("100", "꽝"))).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("numberOfLinks(): 하나의 Line에 그려지는 Link의 개수를 반환한다. Link의 개수는 players.numberOfPlayers() - 1과 동일하다.")
    void testNumberOfLinks() {
        Players players = PlayersUtilForTest.newPlayers("a", "b", "c");
        WinningContents winningContents = newWinningContents("100", "꽝", "1000");
        PlayersAndWinningContents playersAndWinningContents = new PlayersAndWinningContents(players, winningContents);

        assertThat(playersAndWinningContents.numberOfLinkedUnLinked()).isEqualTo(players.numberOfPlayers() - 1);
    }
}
