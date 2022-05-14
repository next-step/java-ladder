package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.strategy.ConnectStrategy;
import ladder.domain.strategy.FixedConnectStrategy;
import ladder.domain.strategy.RandomConnectStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderLinesTest {

  @Test
  @DisplayName("사다리 라인들이 연결전략에 의해서 잘 생성되는지 확인")
  void of() {
    List<ConnectStrategy> connectStrategies = new ArrayList<>();
    connectStrategies.add(new FixedConnectStrategy(List.of(true, true, true)));
    connectStrategies.add(new FixedConnectStrategy(List.of(false, false, false)));
    connectStrategies.add(new FixedConnectStrategy(List.of(true, false, true)));
    LadderLines ladderLines = LadderLines.of(3, connectStrategies);

    IntStream.range(0, connectStrategies.size())
        .forEach(height -> IntStream.range(0, 3)
            .forEach(lineIdx -> assertThat(connectStrategies.get(height).isConnect(lineIdx))
                .isEqualTo(ladderLines.isConnect(height, lineIdx))));
  }

  @ParameterizedTest
  @DisplayName("사다리 라인들의 높이를 정확하게 가져오는지 확인")
  @ValueSource(ints = {1, 5, 9, 20, 30})
  void height(int height) {
    List<ConnectStrategy> strategies = IntStream.range(0, height)
        .mapToObj(i -> new RandomConnectStrategy(3))
        .collect(Collectors.toList());
    LadderLines ladderLines = LadderLines.of(3, strategies);
    assertThat(ladderLines.height()).isEqualTo(height);
  }

  @Test
  @DisplayName("사다리 라인들에서 해당하는 라인을 잘 가져오는지 확인")
  void getLadderLine() {
    List<ConnectStrategy> connectStrategies = new ArrayList<>();
    connectStrategies.add(new FixedConnectStrategy(List.of(true, true, true)));
    connectStrategies.add(new FixedConnectStrategy(List.of(false, false, false)));
    connectStrategies.add(new FixedConnectStrategy(List.of(true, false, true)));
    LadderLines ladderLines = LadderLines.of(3, connectStrategies);

    IntStream.range(0, connectStrategies.size())
        .forEach(height -> assertThat(ladderLines.getLadderLine(height)).usingRecursiveComparison()
            .isEqualTo(LadderLine.of(3, connectStrategies.get(height))));
  }
}