package ladder.model.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayersTest {

  @ParameterizedTest
  @CsvSource(value = {"vat, set, add:set"}, delimiter = ':')
  @DisplayName("생성 가능한 이름들 공백 붙여 테스트")
  void validNameTest(String inputNames, String testName) {
    Players players = Players.initNames(inputNames);
    Player targetPlayer = new Player(testName);

    Assertions.assertThat(players.isNameContains(targetPlayer)).isTrue();
  }
}