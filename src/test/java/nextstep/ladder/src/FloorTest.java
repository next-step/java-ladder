package nextstep.ladder.src;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FloorTest {
  @ParameterizedTest
  @CsvSource(value = {"3:3"}, delimiter = ':')
  @DisplayName("make by width floor, size check")
  public void construct(int width, int size) {
    Floor floor = Floor.makeByWidht(width);

    assertThat(floor.floor().size()).isEqualTo(size);
  }
}
