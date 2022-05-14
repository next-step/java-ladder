package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.strategy.FixedLadderConnectStrategy;
import ladder.domain.strategy.LadderConnectStrategy;
import ladder.domain.strategy.RandomLadderConnectStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderLinesTest {

  @Test
  @DisplayName("사다리 라인들이 연결전략에 의해서 잘 생성되는지 확인")
  void of() {
    LadderConnectStrategy connectStrategy = new FixedLadderConnectStrategy(
        List.of(List.of(true, true, true), List.of(false, false, false),
            List.of(true, false, true)));
    LadderLines ladderLines = LadderLines.of(3, connectStrategy);

    assertThat(ladderLines).usingRecursiveComparison()
        .isEqualTo(LadderLines.of(3, connectStrategy));
  }

  @Test
  @DisplayName("사다리 라인들의 특정 포인트 연결 여부를 잘 가져오는지 확인")
  void isConnect() {
    LadderConnectStrategy connectStrategy = new FixedLadderConnectStrategy(
        List.of(List.of(true, true, true), List.of(false, false, false),
            List.of(true, false, true)));
    LadderLines ladderLines = LadderLines.of(3, connectStrategy);

    for (int height = 0; height < 3; height++) {
      List<Boolean> connects = new ArrayList<>();
      for (int lineIdx = 0; lineIdx < 3; lineIdx++) {
        connects.add(ladderLines.isConnect(height, lineIdx));
      }
      assertThat(connects).isEqualTo(connectStrategy.create(height));
    }
  }

  @ParameterizedTest
  @DisplayName("사다리 라인들의 높이를 정확하게 가져오는지 확인")
  @ValueSource(ints = {1, 5, 9, 20, 30})
  void height(int height) {
    LadderConnectStrategy connectStrategy = new RandomLadderConnectStrategy(height, 3);
    LadderLines ladderLines = LadderLines.of(height, connectStrategy);
    assertThat(ladderLines.height()).isEqualTo(height);
  }

  @Test
  @DisplayName("사다리 라인들에서 해당하는 라인을 잘 가져오는지 확인")
  void getLadderLine() {
    LadderConnectStrategy connectStrategy = new FixedLadderConnectStrategy(
        List.of(List.of(true, true, true), List.of(false, false, false),
            List.of(true, false, true)));
    int height = 3;
    LadderLines ladderLines = LadderLines.of(height, connectStrategy);

    IntStream.range(0, height)
        .forEach(h -> assertThat(ladderLines.getLadderLine(h)).usingRecursiveComparison()
            .isEqualTo(LadderLine.of(connectStrategy.create(h))));
  }
}