package ladderGame.step4.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import ladderGame.step4.model.Ladder;
import ladderGame.step4.model.MatchResult;
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
    List<String> players = ladderService.createPlayers("user1,user2");
    assertThat(players).containsExactly("user1","user2");
  }

  @DisplayName("사다리 객체 생성 이전 사용자 생성 검증 테스트.")
  @Test
  void validationLadderCreate() {
    LadderService ladderService = new LadderService();
    assertThatThrownBy(() -> ladderService.createLadder(1))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("사다리 객체 생성 테스트.")
  @Test
  void createLadder() {
    LadderService ladderService = new LadderService();

    ladderService.createPlayers("user1,user2");
    Ladder ladder = ladderService.createLadder(1);

    assertThat(ladder.ladderValues().size()).isEqualTo(1);
  }


  @DisplayName("상품결과 생성 이전 사용자 생성 검증 테스트.")
  @Test
  void validationPrizesCreate() {
    LadderService ladderService = new LadderService();
    assertThatThrownBy(() -> ladderService.createPrizes("g1,g2,g3"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("상품결과 객체 생성 테스트.")
  @Test
  void creatPrizes() {
    LadderService ladderService = new LadderService();
    ladderService.createPlayers("user1,user2");
    Prizes prizes = ladderService.createPrizes("good1,good2");

    assertThat(prizes.prizeNames().size()).isEqualTo(2);
    assertThat(prizes.prizeNames()).containsExactly("good1","good2");
  }

  @DisplayName("결과값 생성 이전 사용자,사다리,상품 객체 검증 테스트.")
  @Test
  void validationMatchResultCreate() {
    LadderService ladderService = new LadderService();
    assertThatThrownBy(() -> ladderService.getMatchResults("user1"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("결과값 반환 검증.")
  @ParameterizedTest
  @CsvSource(value = {"user1,1","user2,1","all,2"})
  void createMatchResult(String name, int count) {
    LadderService ladderService = new LadderService();

    ladderService.createPlayers("user1,user2");
    ladderService.createLadder(1);
    ladderService.createPrizes("good1,good2");

    List<MatchResult> user1 = ladderService.getMatchResults(name);

    assertThat(user1.size()).isEqualTo(count);
  }
}