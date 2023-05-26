package ladder.domain.player;

import config.BaseTest;
import exception.ExceptionCode;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerGeneratorTest extends BaseTest {

  private PlayerGenerator sut;

  @BeforeEach
  void setup() {
    sut = DefaultPlayerGenerator.getInstance();
  }

  @Test
  @DisplayName("플레이어목록에 동일한 이름이 있는 경우, 플레이어 목록을 생성 할 수 없다.")
  void 플레이어_생성시_이름은_고유해야한다() {
    // given
    List<String> 플레이어_이름_목록 = Arrays.asList("sight", "sight", "seol");

    // when & then
    super.assertThatThrowsLadderGameException(
        () -> sut.generatePlayerList(플레이어_이름_목록),
        ExceptionCode.DUPLICATE_PLAYER_IN_GAME
    );
  }

  @Test
  @DisplayName("플레이어는 최소 두명 이상아여야 생성 할 수 있다.")
  void 플레이어_목록은_최소_두명_이상이여야_한다() {
    // given
    List<String> 플레이어_이름_목록 = Arrays.asList("sight");

    // when & then
    super.assertThatThrowsLadderGameException(
        () -> sut.generatePlayerList(플레이어_이름_목록),
        ExceptionCode.MIN_PLAYER_COUNT_REQUIRED
    );
  }
}
