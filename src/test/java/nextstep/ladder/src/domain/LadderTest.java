package nextstep.ladder.src.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderTest {

  @ParameterizedTest
  @CsvSource(value = {"0:1", "1:0"}, delimiter = ':')
  @DisplayName("min size exception")
  public void minSizeException(int height, int width) {
    assertThatThrownBy(() -> {
      Ladder.makeLadderBySize(height, width);
    }).isInstanceOf(IllegalArgumentException.class);
  }
}
