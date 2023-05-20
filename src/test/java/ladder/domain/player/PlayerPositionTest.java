package ladder.domain.player;

import config.BaseTest;
import ladder.domain.ladder.line.point.LadderPointDirection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerPositionTest extends BaseTest {

  @Test
  @DisplayName("PlayerPosition.move() | 사다리게임 참가자는 같은 높이에서 이동한 방향으로 다시 돌아가지 않는다 (좌우)")
  void 같은_높이에서_좌우_반복이동시_원위치_안됨_좌우() {

    // given
    PlayerPosition position = new PlayerPosition(0);

    // when
    position.move(LadderPointDirection.RIGHT);
    position.move(LadderPointDirection.LEFT);

    // then
    Assertions.assertThat(position)
        .extracting("currentLine", "currentHeight")
        .containsExactly(1, 1);
  }

  @Test
  @DisplayName("PlayerPosition.move() | 사다리게임 참가자는 같은 높이에서 이동한 방향으로 다시 돌아가지 않는다 (우좌)")
  void 같은_높이에서_좌우_반복이동시_원위치_안됨_반대() {

    // given
    PlayerPosition position = new PlayerPosition(1);

    // when
    position.move(LadderPointDirection.LEFT);
    position.move(LadderPointDirection.RIGHT);

    // then
    Assertions.assertThat(position)
        .extracting("currentLine", "currentHeight")
        .containsExactly(0, 1);
  }

  @Test
  @DisplayName("PlayerPosition.move() | 사다리게임에서 좌우로 이동 할 수 없는 경우 아래로 이동한다.")
  void 같은_높이에서_좌우_이동_안되면_아래로_이동() {

    // given
    PlayerPosition position = new PlayerPosition(0);

    // when
    position.move(LadderPointDirection.NONE);

    // then
    Assertions.assertThat(position)
        .extracting("currentLine", "currentHeight")
        .containsExactly(0, 1);
  }
}
