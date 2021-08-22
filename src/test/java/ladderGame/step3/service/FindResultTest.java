package ladderGame.step3.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladderGame.step3.model.Ladder;
import ladderGame.step3.model.Players;
import ladderGame.step3.model.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FindResultTest {

  @DisplayName("검색대상자가 게임중인 플레이어 중에 없을 경우 검증.")
  @Test
  void searchIndexByPlayers() {
    Players players = new Players(Players.of("user1,user2"));
    Prizes prizes = new Prizes(Prizes.createPrizes("100, 200", players.count()));
    Ladder ladder = new Ladder(Ladder.of(1, players.count()));

    FindResult findResult = new FindResult(players, ladder, prizes);
    findResult.matchPrizes("user1");

    assertThatThrownBy(() -> findResult.matchPrizes("user3"))
        .isInstanceOf(IllegalArgumentException.class);
  }
}