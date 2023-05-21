package nextstep.laddergame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderInfoTest {

  @DisplayName("사다리의 높이와 넓이는 1보다 작을 수 없다.")
  @Test
  public void heightAndWidth_throwException_ifLessThan1() {
    assertAll(
        () -> assertThatThrownBy(() -> new LadderInfo(-1, 1))
            .isInstanceOf(IllegalArgumentException.class),
        () -> assertThatThrownBy(() -> new LadderInfo(1, -1))
            .isInstanceOf(IllegalArgumentException.class),
        () -> assertThatThrownBy(() -> new LadderInfo(0, 0))
            .isInstanceOf(IllegalArgumentException.class)
    );
  }

  @DisplayName("높이만큼의 Row수를 갖는 Ladder를 생성한다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 10})
  public void ladder_generateLadder(int input) {
    LadderInfo ladderInfo = new LadderInfo(input, 1);
    Ladder ladder = ladderInfo.generateLadder((leftPoint, rightPoint) -> false);

    assertThat(ladder.getRows().size()).isEqualTo(input);
  }

}
