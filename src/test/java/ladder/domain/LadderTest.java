package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {
  @Test
  void 잘못된_사다리_입력_시_예외() {
    assertThatThrownBy(() -> Ladders.rows(new int[][]{
                    {1, 0, 1},
                    {0, 1, 0},
                    {1, 0, 1},
                    {0, 0, 0},
                    {1, 1, 1}
            }))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void 정상_사다리_생성() {
    Ladders.rows(new int[][]{
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
    });
  }
}
