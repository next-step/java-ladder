package nextstep.ladder.src;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
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

  @RepeatedTest(value = 100)
  @DisplayName("bridge not overlap")
  public void bridgeNotOverlap() {
    final int WIDTH = 10;
    List<Bridge> floor = Floor.makeByWidht(WIDTH).floor();
    
    for(int i = 1; i < WIDTH; i++) {
      boolean bool = floor.get(i - 1).isBridge() && floor.get(i).isBridge();
      assertThat(bool).isFalse();
    }
  }
  
}
