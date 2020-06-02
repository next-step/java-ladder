package ladder.step3.domain;

import ladder.step3.domain.*;
import ladder.step3.domain.strategy.LadderLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {

  @DisplayName("사다리의 높이를 정상적으로 주입 받았는지 확인하는 테스트")
  @ParameterizedTest
  @MethodSource("provideLadderAndHeight")
  void 사다리_높이_확인_테스트 (Ladder ladder, long expected) {
    assertEquals(expected, ladder.stream().count());
  }

  private static Stream<Arguments> provideLadderAndHeight () {
    Participants participants = Participants.ofString("a,b,c,d,e");
    LadderLineStrategy strategy = prev -> true;
    return Stream.of(
      Arguments.of(Ladder.of(participants, LadderHeight.valueOf(5), strategy), 5),
      Arguments.of(Ladder.of(participants, LadderHeight.valueOf(4), strategy), 4),
      Arguments.of(Ladder.of(participants, LadderHeight.valueOf(3), strategy), 3),
      Arguments.of(Ladder.of(participants, LadderHeight.valueOf(2), strategy), 2),
      Arguments.of(Ladder.of(participants, LadderHeight.valueOf(1), strategy), 1)
    );
  }

  @DisplayName("사다리가 규칙에 맞게 잘 정상적으로 잘 생성 되는지 테스트")
  @ParameterizedTest
  @MethodSource("provideLadder")
  void 사다리_생성_테스트 (Ladder ladder, List<List<Boolean>> shape) {
    assertThat(
      ladder.stream()
        .map(ladderLine -> ladderLine.stream()
          .collect(toList()))
        .collect(toList())).isEqualTo(shape);
  }

  private static Stream<Arguments> provideLadder () {
    Participants participants = Participants.ofString("aa,bb,cc,dd");
    LadderHeight ladderHeight = LadderHeight.valueOf(3);
    return Stream.of(
      Arguments.of(
        Ladder.of(participants, ladderHeight, prev -> !prev),
        Arrays.asList(
          Arrays.asList(true, false, true),
          Arrays.asList(true, false, true),
          Arrays.asList(true, false, true)
        )
      ),
      Arguments.of(
        Ladder.of(participants, ladderHeight, prev -> true),
        Arrays.asList(
          Arrays.asList(true, true, true),
          Arrays.asList(true, true, true),
          Arrays.asList(true, true, true)
        )
      ),
      Arguments.of(
        Ladder.of(participants, ladderHeight, prev -> false),
        Arrays.asList(
          Arrays.asList(false, false, false),
          Arrays.asList(false, false, false),
          Arrays.asList(false, false, false)
        )
      )
    );
  }
}
