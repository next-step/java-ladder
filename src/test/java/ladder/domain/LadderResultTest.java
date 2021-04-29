package ladder.domain;

import ladder.rule.LineRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

  @Test
  @DisplayName("사다리 결과 테스트")
  void generate() {
    // given
    Players players = Players.create("gmoon, guest, test");
    List<Player> playersValues = players.getValues();
    Depth depthOfDrawing = Depth.generate(LineRule.drawing(), playersValues.size() - 1);

    // when
    Map<Player, Integer> playerIndexs = getPlayerResultIndexs(playersValues, Arrays.asList(depthOfDrawing, depthOfDrawing));

    // then
    assertThat(playerIndexs.get(Player.create("gmoon"))).isZero();
    assertThat(playerIndexs.get(Player.create("guest"))).isEqualTo(1);
    assertThat(playerIndexs.get(Player.create("test"))).isEqualTo(playerIndexs.get(Player.create("test")));
  }

  private Map<Player, Integer> getPlayerResultIndexs(List<Player> playersValues, List<Depth> depths) {
    Map<Player, Integer> playerIndexs = playersValues.stream()
            .collect(Collectors.toMap(Function.identity(), playersValues::indexOf));

    for (int i = 0; i < playersValues.size(); i++) {
      Player key = playersValues.get(i);
      for (Depth depth : depths) {
        playerIndexs.put(key, getNextDepthStartIndex(depth, playerIndexs.get(key)));
      }
    }
    return playerIndexs;
  }

  private int getNextDepthStartIndex(Depth depth, int i) {
    final int indexOfLeftLine = i - 1;
    final int indexOfRightLine = i;

    List<Line> lines = depth.getValues();
    boolean existOfLeft = existLine(lines, indexOfLeftLine);
    boolean existOfRight = existLine(lines, indexOfRightLine);

    if (existOfLeft) {
      return i--;
    }

    if (existOfRight) {
      return i++;
    }

    return i;
  }

  private boolean existLine(List<Line> lines, int i) {
    final int firstLineIndex = 0;
    boolean isValidLineIndexBounds = firstLineIndex <= i && i < lines.size();
    if (isValidLineIndexBounds) {
      return !lines.get(i).isEmpty();
    }
    return false;
  }
}