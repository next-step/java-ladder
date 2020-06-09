package laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerTest {

  @ParameterizedTest
  @CsvSource({
      "test"
  })
  void createByNameStr(String nameStr) {
    assertThat(Player.createByNameStr(nameStr).getName()).isEqualTo(new Name(nameStr));
  }

}