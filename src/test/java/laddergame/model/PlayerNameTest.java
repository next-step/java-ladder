package laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerNameTest {

  @ParameterizedTest
  @CsvSource({
      "test"
  })
  void createBy(String name) {
        assertThat(PlayerName.createBy(name).toString().trim()).isEqualTo(name);
  }
}