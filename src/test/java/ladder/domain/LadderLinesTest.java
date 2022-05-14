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
    LadderLines ladderLines = LadderLines.of(connectStrategies);

    assertThat(ladderLines).usingRecursiveComparison().isEqualTo(LadderLines.of(connectStrategies));
  }

  @Test
  @DisplayName("사다리 라인들의 특정 포인트 연결 여부를 잘 가져오는지 확인")
  void isConnect() {
    List<ConnectStrategy> connectStrategies = new ArrayList<>();
    connectStrategies.add(new FixedConnectStrategy(List.of(true, true, true)));
    connectStrategies.add(new FixedConnectStrategy(List.of(false, false, false)));
    connectStrategies.add(new FixedConnectStrategy(List.of(true, false, true)));
    LadderLines ladderLines = LadderLines.of(connectStrategies);

    for (int height = 0; height < connectStrategies.size(); height++) {
      List<Boolean> connects = new ArrayList<>();
      for (int lineIdx = 0; lineIdx < 3; lineIdx++) {
        connects.add(ladderLines.isConnect(height, lineIdx));
      }
      assertThat(connects).isEqualTo(connectStrategies.get(height).create());
    }
  }

  @ParameterizedTest
  @DisplayName("사다리 라인들의 높이를 정확하게 가져오는지 확인")
  @ValueSource(ints = {1, 5, 9, 20, 30})
  void height(int height) {
    List<ConnectStrategy> strategies = IntStream.range(0, height)
        .mapToObj(i -> new RandomConnectStrategy(3))
        .collect(Collectors.toList());
    LadderLines ladderLines = LadderLines.of(strategies);
    assertThat(ladderLines.height()).isEqualTo(height);
  }

  @Test
  @DisplayName("사다리 라인들에서 해당하는 라인을 잘 가져오는지 확인")
  void getLadderLine() {
    List<ConnectStrategy> connectStrategies = new ArrayList<>();
    connectStrategies.add(new FixedConnectStrategy(List.of(true, true, true)));
    connectStrategies.add(new FixedConnectStrategy(List.of(false, false, false)));
    connectStrategies.add(new FixedConnectStrategy(List.of(true, false, true)));
    LadderLines ladderLines = LadderLines.of(connectStrategies);

    IntStream.range(0, connectStrategies.size())
        .forEach(height -> assertThat(ladderLines.getLadderLine(height)).usingRecursiveComparison()
            .isEqualTo(LadderLine.of(connectStrategies.get(height))));
  }
}