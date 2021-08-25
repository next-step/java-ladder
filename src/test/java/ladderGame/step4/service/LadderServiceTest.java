package ladderGame.step4.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladderGame.step4.model.Ladder;
import ladderGame.step4.model.MatchResult;
import ladderGame.step4.model.Players;
import ladderGame.step4.model.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderServiceTest {

  @DisplayName("사용자 객체 생성 테스트.")
  @Test
  void createPlayers() {
    LadderService ladderService = new LadderService();
    List<String> players = ladderService.createPlayers("user1,user2").playersName();
    assertThat(players).containsExactly("user1", "user2");
  }

  @DisplayName("사다리 객체 생성 테스트.")
  @Test
  void createLadder() {
    LadderService ladderService = new LadderService();

    List<String> players = ladderService.createPlayers("user1,user2").playersName();
    Ladder ladder = ladderService.createLadder(1, players.size());

    assertThat(ladder.ladderValues().size()).isEqualTo(1);
  }

  @DisplayName("상품결과 객체 생성 테스트.")
  @Test
  void creatPrizes() {
    LadderService ladderService = new LadderService();
    ladderService.createPlayers("user1,user2");
    Prizes prizes = ladderService.createPrizes("good1,good2", 2);

    assertThat(prizes.prizeNames().size()).isEqualTo(2);
    assertThat(prizes.prizeNames()).containsExactly("good1", "good2");
  }

  @DisplayName("결과값 반환 검증.")
  @ParameterizedTest
  @CsvSource(value = {"user1,1", "user2,1", "all,2"})
  void createMatchResult(String name, int count) {
    LadderService ladderService = new LadderService();

    Players players = ladderService.createPlayers("user1,user2");
    Ladder ladder = ladderService.createLadder(1, players.playersName().size());

    List<MatchResult> user1 = ladderService.getMatchResults(ladder, players, name);

    assertThat(user1.size()).isEqualTo(count);
  }
}