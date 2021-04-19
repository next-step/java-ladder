package ladder.model.member;

import ladder.error.InvalidNameException;
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

  @ParameterizedTest
  @CsvSource(value = {"vat"}, delimiter = ':')
  @DisplayName("하나만 들어왔을 때 테스트")
  void invalidNameTest(String inputNames) {
    Assertions.assertThatThrownBy(() -> Players.initNames(inputNames)).isInstanceOf(InvalidNameException.class).hasMessage("참가자의 수는 최소 2명입니다.");
  }

}
